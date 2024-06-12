package br.pucrs.pedroviganico;

import org.junit.Test;
import static org.junit.Assert.*;


public class DateCalculatorTest {

    @Test
    public void testGetNextDate_validDate() {
        assertEquals("02/01/2021", DateCalculator.getNextDate("01/01/2021"));
    }

    @Test
    public void testGetNextDate_endOfMonth() {
        assertEquals("01/02/2021", DateCalculator.getNextDate("31/01/2021"));
    }

    @Test
    public void testGetNextDate_endOfYear() {
        assertEquals("01/01/2022", DateCalculator.getNextDate("31/12/2021"));
    }

    @Test
    public void testGetNextDate_leapYear() {
        assertEquals("29/02/2020", DateCalculator.getNextDate("28/02/2020"));
    }

    @Test
    public void testGetNextDate_nonLeapYear() {
        assertEquals("01/03/2019", DateCalculator.getNextDate("28/02/2019"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNextDate_invalidDate() {
        DateCalculator.getNextDate("32/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNextDate_invalidCharacters() {
        DateCalculator.getNextDate("abcd/ef/ghij");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidLength() {
        DateCalculator.getNextDate("1/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidFormat() {
        DateCalculator.getNextDate("01-01-2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidDay() {
        DateCalculator.getNextDate("32/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidMonth() {
        DateCalculator.getNextDate("01/13/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidFebruaryDay_nonLeapYear() {
        DateCalculator.getNextDate("29/02/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidFebruaryDay_leapYear() {
        DateCalculator.getNextDate("30/02/2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidAprilDay() {
        DateCalculator.getNextDate("31/04/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidYear() {
        DateCalculator.getNextDate("01/01/1599");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidPartsLength() {
        DateCalculator.getNextDate("01/1/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidPartsFormat() {
        DateCalculator.validateDateFormat("01/01/21");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidNumberOfParts() {
        DateCalculator.getNextDate("01/01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaDiaMaior(){
        DateCalculator.validateDateFormat("35/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMesMaior(){
        DateCalculator.validateDateFormat("01/13/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaAnoMaior(){
        DateCalculator.validateDateFormat("01/01/9999");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaDiaMenor(){
        DateCalculator.validateDateFormat("00/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMesMenor(){
        DateCalculator.validateDateFormat("01/00/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaAnoMenor(){
        DateCalculator.validateDateFormat("01/01/1599");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMes4(){
        DateCalculator.validateDateFormat("31/04/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes6(){
        DateCalculator.validateDateFormat("31/06/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes9(){
        DateCalculator.validateDateFormat("31/09/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes11(){
        DateCalculator.validateDateFormat("31/11/2022");
    }
    @Test
    public void testeMenorMes4() {
        assertEquals("29/04/2019", DateCalculator.getNextDate("28/04/2019"));
    }
    @Test
    public void testeMenorMes6() {
        assertEquals("29/06/2019", DateCalculator.getNextDate("28/06/2019"));
    }
    @Test
    public void testeMenorMes9() {
        assertEquals("29/09/2019", DateCalculator.getNextDate("28/09/2019"));
    }
    @Test
    public void testeMenorMes11() {
        assertEquals("29/11/2019", DateCalculator.getNextDate("28/11/2019"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao(){
        DateCalculator.validateDateFormat("ww/ww/wwww");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao2(){
        DateCalculator.validateDateFormat("ww.11/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao3(){
        DateCalculator.validateDateFormat("22.01.2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao4(){
        DateCalculator.validateDateFormat("0/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao5(){
        DateCalculator.validateDateFormat("01/0/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao6(){
        DateCalculator.validateDateFormat("01/01/150");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao7(){
        DateCalculator.validateDateFormat("01/01/1500");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao9(){
        DateCalculator.validateDateFormat("202/2");
    }
    
   
    @Test(expected = IllegalArgumentException.class)
    public void testMissingSlashInDate() {
        DateCalculator.validateDateFormat("01012022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFormat() {
        DateCalculator.validateDateFormat("01-01-2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLettersInDate() {
        DateCalculator.validateDateFormat("01/AB/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFormat() {
        DateCalculator.validateDateFormat("01.01/2222");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidDate() {
        DateCalculator.validateDateFormat("ww/ww/wwww");
    }

    @Test
    public void testNextDate() {
        assertEquals("02/01/2022", DateCalculator.getNextDate("01/01/2022"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoSlashPresent() {
        DateCalculator.validateDateFormat("01012022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectSlashUsage() {
        DateCalculator.validateDateFormat("ww.ww.wwww");
    }
    @Test
    public void testIsLeapYear() {
        assertTrue(DateCalculator.isLeapYear(2020));
        assertFalse(DateCalculator.isLeapYear(2021));
        assertFalse(DateCalculator.isLeapYear(1900));
    }
}
