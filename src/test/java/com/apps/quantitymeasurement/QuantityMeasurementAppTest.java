package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.LengthUnit;

public class QuantityMeasurementAppTest {
    @Test
    public void testEquality_YardToYard_SameValue() {
        assertEquals(new Length(1.0, LengthUnit.YARDS), new Length(1.0, LengthUnit.YARDS));
    }
    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        assertEquals(new Length(1.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET));
    }
    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        assertEquals(new Length(1.0, LengthUnit.YARDS), new Length(36.0, LengthUnit.INCHES));
    }
    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        assertEquals(new Length(1.0, LengthUnit.CENTIMETERS), new Length(0.393701, LengthUnit.INCHES));
    }
    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches); // Transitive check
    }
    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        assertNotEquals(new Length(1.0, LengthUnit.CENTIMETERS), new Length(1.0, LengthUnit.FEET));
    }
    @Test
    public void testEquality_YardNullComparison() {
        assertNotEquals(new Length(1.0, LengthUnit.YARDS), null);
    }
}
