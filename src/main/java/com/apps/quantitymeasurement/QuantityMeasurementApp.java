package com.apps.quantitymeasurement;
import java.util.Objects;
public class QuantityMeasurementApp {
    public enum LengthUnit {
        YARDS(36.0),        // 1 yard = 3 feet = 36 inches
        FEET(12.0),         // 1 foot = 12 inches
        INCHES(1.0),        // Base unit
        CENTIMETERS(0.393701); // 1 cm = 0.393701 inches
        private final double conversionFactor;
        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }
        public double getConversionFactor() {
            return conversionFactor;
        }
    }
    public static class Length {
        private final double value;
        private final LengthUnit unit;
        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }
        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Length that = (Length) o;
            return Math.abs(this.convertToBaseUnit() - that.convertToBaseUnit()) < 0.00001;
        }
        @Override
        public int hashCode() {
            return Objects.hash(value, unit);
        }
    }
    public static void main(String[] args) {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, LengthUnit.INCHES);
        System.out.println("1 Yard == 3 Feet: " + yard.equals(feet));
        System.out.println("1 CM == 0.393701 Inch: " + cm.equals(inch));
    }
}
