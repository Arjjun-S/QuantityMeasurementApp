package com.apps.quantitymeasurement;
import java.util.Objects;
public class QuantityMeasurementApp {
    public static class Length {
        private final double value;
        private final LengthUnit unit;
        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);
            private final double conversionFactor;
            LengthUnit(double conversionFactor) {
                this.conversionFactor = conversionFactor;
            }

            public double getConversionFactor() {
                return conversionFactor;
            }
        }
        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }
        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit must not be null");
            }
            double baseValue = this.value * this.unit.getConversionFactor();
            double convertedValue = baseValue / targetUnit.getConversionFactor();
            double roundedValue = Math.round(convertedValue * 100.0) / 100.0;
            return new Length(roundedValue, targetUnit);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Length that = (Length) o;
            double thisBase = this.value * this.unit.getConversionFactor();
            double thatBase = that.value * that.unit.getConversionFactor();
            return Math.abs(thisBase - thatBase) < 0.02;
        }
        @Override
        public int hashCode() {
            return Objects.hash(value, unit);
        }
        @Override
        public String toString() {
            return String.format("%.2f %s", value, unit);
        }
    }
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        boolean isEqual = length1 != null && length1.equals(length2);
        if (isEqual) System.out.println("The two length measurements are equal.");
        else System.out.println("The two length measurements are not equal.");
        return isEqual;
    }
    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1, double v2, Length.LengthUnit u2) {
        return demonstrateLengthEquality(new Length(v1, u1), new Length(v2, u2));
    }
    public static Length demonstrateLengthConversion(double value, Length.LengthUnit fromUnit, Length.LengthUnit toUnit) {
        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }
    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }
    public static void main(String[] args) {
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARDS);
    }
}
