package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {
    @Test
    public void testEquality_FeetToFeet_SameValue() {
        assertEquals(new Length(1.0, LengthUnit.FEET), new Length(1.0, LengthUnit.FEET));
    }
    @Test
    public void testEquality_InchToInch_SameValue() {
        assertEquals(new Length(1.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.INCHES));
    }
    @Test
    public void testEquality_FeetToInches_EquivalentValue() {
        assertEquals(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES));
    }
    @Test
    public void testEquality_InchesToFeet_EquivalentValue() {
        assertEquals(new Length(12.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.FEET));
    }
    @Test
    public void testEquality_DifferentValue() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), new Length(2.0, LengthUnit.FEET));
    }
    @Test
    public void testEquality_NullComparison() {
        assertNotEquals(new Length(1.0, LengthUnit.FEET), null);
    }
    @Test
    public void testEquality_SameReference() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertEquals(length, length);
    }
}
