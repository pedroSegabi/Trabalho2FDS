package br.pucrs.pedroviganico;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DateCalculatorTest {

    @Test
    public void testGetNextDateValid() {
        assertEquals("02/01/2020", DateCalculator.getNextDate("01/01/2020"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate() {
        DateCalculator.getNextDate("32/01/2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormatLength() {
        DateCalculator.validateDateFormat("1/01/2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormatInvalid() {
        DateCalculator.validateDateFormat("01-01-2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormatDigits() {
        DateCalculator.validateDateFormat("aa/bb/cccc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDate2(){
        DateCalculator.getNextDate("29/02/2023");
    }

    @Test
    public void testGetNextDateLeapYear() {
        assertEquals("29/02/2020", DateCalculator.getNextDate("28/02/2020"));
    }

    @Test
    public void testGetNextDateNonLeapYear() {
        assertEquals("01/03/2021", DateCalculator.getNextDate("28/02/2021"));
    }

    @Test
    public void testGetNextDateEndOfMonth() {
        assertEquals("01/05/2021", DateCalculator.getNextDate("30/04/2021"));
    }

    @Test
    public void testGetNextDateEndOfYear() {
        assertEquals("01/01/2021", DateCalculator.getNextDate("31/12/2020"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFebruaryNonLeapYear() {
        DateCalculator.getNextDate("29/02/2021");
    }

    @Test
    public void testGetNextDateEndOfFebruaryLeapYear() {
        assertEquals("01/03/2020", DateCalculator.getNextDate("29/02/2020"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateMonth() {
        DateCalculator.getNextDate("31/13/2020");
    }

    @Test
    public void testGetNextDateValidEndOfMonth() {
        assertEquals("01/03/2020", DateCalculator.getNextDate("29/02/2020"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFebruary() {
        DateCalculator.getNextDate("30/02/2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateApril() {
        DateCalculator.getNextDate("31/04/2020");
    }


    @Test
    public void testGetNextDateEndOfShortMonth() {
        assertEquals("01/10/2021", DateCalculator.getNextDate("30/09/2021"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateShortMonth() {
        DateCalculator.getNextDate("31/09/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayForMonth() {
        DateCalculator.getNextDate("31/11/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayForFebruaryLeapYear() {
        DateCalculator.getNextDate("30/02/2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayForFebruaryNonLeapYear() {
        DateCalculator.getNextDate("29/02/2021");
    }

    @Test
    public void testGetNextDateEndOfMonth31Days() {
        assertEquals("01/08/2021", DateCalculator.getNextDate("31/07/2021"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayForApril() {
        DateCalculator.getNextDate("31/04/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayForJune() {
        DateCalculator.getNextDate("31/06/2021");
    }
}
