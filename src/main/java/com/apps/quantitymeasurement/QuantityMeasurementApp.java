package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            // 1. Reference Check
            if (this == o) return true;

            // 2. Null and Type Check
            if (o == null || getClass() != o.getClass()) return false;

            // 3. Cast and Value Comparison
            Feet feet = (Feet) o;
            return Double.compare(feet.value, value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + f1.equals(f2) + ")");
    }
}
