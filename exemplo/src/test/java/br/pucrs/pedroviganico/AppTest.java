package br.pucrs.pedroviganico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class DateCalculatorTest {

    @Test
    public void testGetNextDateValid() {
        assertEquals("02/01/2020", DateCalculator.getNextDate("01/01/2020"));
    }

    @Test
    public void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateCalculator.getNextDate("32/01/2020");
        });
    }

    @Test
    public void testValidateDateFormatLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateCalculator.validateDateFormat("1/01/2020");
        });
    }

    @Test
    public void testValidateDateFormatInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateCalculator.validateDateFormat("01-01-2020");
        });
    }

    @Test
    public void testValidateDateFormatDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateCalculator.validateDateFormat("aa/bb/cccc");
        });
    }
}
