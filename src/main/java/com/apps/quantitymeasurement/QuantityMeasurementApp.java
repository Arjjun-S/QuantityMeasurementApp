package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);
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
            return Double.compare(this.convertToBaseUnit(), that.convertToBaseUnit()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(convertToBaseUnit());
        }
    }
    public static void main(String[] args) {
        Length oneFeet = new Length(1.0, LengthUnit.FEET);
        Length twelveInches = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Input: 1.0 ft and 12.0 inches");
        System.out.println("Output: Equal (" + oneFeet.equals(twelveInches) + ")");
    }
}
