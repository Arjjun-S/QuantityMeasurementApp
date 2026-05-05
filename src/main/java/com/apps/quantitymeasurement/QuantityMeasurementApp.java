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
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            this.value = value;
            this.unit = unit;
        }
        public double getValue() { return value; }
        public LengthUnit getUnit() { return unit; }
        private double getBaseValue() {
            return value * unit.getConversionFactor();
        }
        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            double convertedValue = this.getBaseValue() / targetUnit.getConversionFactor();
            return new Length(Math.round(convertedValue * 100.0) / 100.0, targetUnit);
        }
        public Length add(Length that) {
            if (that == null) throw new IllegalArgumentException("Operand cannot be null");
            double sumInBaseValue = this.getBaseValue() + that.getBaseValue();
            double resultValue = sumInBaseValue / this.unit.getConversionFactor();
            return new Length(Math.round(resultValue * 100.0) / 100.0, this.unit);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Length that = (Length) o;
            return Math.abs(this.getBaseValue() - that.getBaseValue()) < 0.02;
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
        System.out.println("The two length measurements are " + (isEqual ? "equal." : "not equal."));
        return isEqual;
    }
    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1, double v2, Length.LengthUnit u2) {
        return demonstrateLengthEquality(new Length(v1, u1), new Length(v2, u2));
    }
    public static Length demonstrateLengthConversion(double value, Length.LengthUnit from, Length.LengthUnit to) {
        return new Length(value, from).convertTo(to);
    }
    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit to) {
        return length.convertTo(to);
    }
    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        Length result = l1.add(l2);
        System.out.println("Adding: " + l1 + " + " + l2 + " = " + result);
        return result;
    }
    public static void main(String[] args) {
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCHES));
    }
}