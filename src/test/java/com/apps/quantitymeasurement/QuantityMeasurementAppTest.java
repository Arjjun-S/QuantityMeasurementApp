package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {
    @Test
    public void testFeetEquality() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.FEET, 1.0, LengthUnit.FEET));
    }
    @Test
    public void testFeetInchesComparison() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES));
    }
    @Test
    public void yardEquals36Inches() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES));
    }
    @Test
    public void testInchesEquality() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.INCHES, 1.0, LengthUnit.INCHES));
    }
    @Test
    public void centimeterEquals39Point3701Inches() {
        Length cm = new Length(100.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(39.3701, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(cm, inches));
    }
    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(30.48, LengthUnit.CENTIMETERS, 1.0, LengthUnit.FEET));
    }
    @Test
    public void threeFeetEqualsOneYard() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS));
    }
    @Test
    public void testFeetInequality() {
        assertFalse(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.FEET, 2.0, LengthUnit.FEET));
    }
    @Test
    public void yardNotEqualToInches() {
        assertFalse(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.YARDS, 1.0, LengthUnit.INCHES));
    }
    @Test
    public void equalsReturnsFalseForNull() {
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(new Length(1.0, LengthUnit.FEET), null));
    }
    @Test
    public void differentValuesSameUnitNotEqual() {
        assertFalse(QuantityMeasurementApp.demonstrateLengthComparison(5.0, LengthUnit.FEET, 10.0, LengthUnit.FEET));
    }
    @Test
    public void convertFeetToInches() {
        Length converted = QuantityMeasurementApp.demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(new Length(36.0, LengthUnit.INCHES), converted);
    }
    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length yards = new Length(2.0, LengthUnit.YARDS);
        Length converted = QuantityMeasurementApp.demonstrateLengthConversion(yards, LengthUnit.INCHES);
        assertEquals(new Length(72.0, LengthUnit.INCHES), converted);
    }
    @Test
    public void addFeetAndInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        Length sum = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        assertEquals(new Length(2.0, LengthUnit.FEET), sum);
    }
    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.FEET);
        Length sum = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        assertEquals(new Length(24.0, LengthUnit.INCHES), sum);
    }
    @Test
    public void testAddition_Commutativity() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(l1.add(l2).getBaseValue(), l2.add(l1).getBaseValue(), 0.01);
    }
    @Test
    public void referenceEqualitySameObject() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length, length));
    }
    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length a = new Length(1.0, LengthUnit.YARDS);
        Length b = new Length(3.0, LengthUnit.FEET);
        Length c = new Length(36.0, LengthUnit.INCHES);
        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }
}
