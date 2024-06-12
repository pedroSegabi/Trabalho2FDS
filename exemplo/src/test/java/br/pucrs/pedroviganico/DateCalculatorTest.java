package br.pucrs.pedroviganico;

import org.junit.Test;
import static org.junit.Assert.*;


public class DateCalculatorTest {
    dataTest dataTest = new dataTest();
    @Test
    public void testGetNextDate_validDate() {
        assertEquals("02/01/2021", dataTest.getNextDate("01/01/2021"));
    }

    @Test
    public void testGetNextDate_endOfMonth() {
        assertEquals("01/02/2021", dataTest.getNextDate("31/01/2021"));
    }

    @Test
    public void testGetNextDate_endOfYear() {
        assertEquals("01/01/2022", dataTest.getNextDate("31/12/2021"));
    }

    @Test
    public void testGetNextDate_leapYear() {
        assertEquals("29/02/2020", dataTest.getNextDate("28/02/2020"));
    }

    @Test
    public void testGetNextDate_nonLeapYear() {
        assertEquals("01/03/2019", dataTest.getNextDate("28/02/2019"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNextDate_invalidDate() {
        dataTest.getNextDate("32/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNextDate_invalidCharacters() {
        dataTest.getNextDate("abcd/ef/ghij");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidLength() {
        dataTest.getNextDate("1/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidFormat() {
        dataTest.getNextDate("01-01-2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidDay() {
        dataTest.getNextDate("32/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidMonth() {
        dataTest.getNextDate("01/13/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidFebruaryDay_nonLeapYear() {
        dataTest.getNextDate("29/02/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidFebruaryDay_leapYear() {
        dataTest.getNextDate("30/02/2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidAprilDay() {
        dataTest.getNextDate("31/04/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidYear() {
        dataTest.getNextDate("01/01/1599");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidPartsLength() {
        dataTest.getNextDate("01/1/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidPartsFormat() {
        dataTest.validateDateFormat("01/01/21");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidNumberOfParts() {
        dataTest.getNextDate("01/01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaDiaMaior(){
        dataTest.validateDateFormat("35/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMesMaior(){
        dataTest.validateDateFormat("01/13/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaAnoMaior(){
        dataTest.validateDateFormat("01/01/9999");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaDiaMenor(){
        dataTest.validateDateFormat("00/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMesMenor(){
        dataTest.validateDateFormat("01/00/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaAnoMenor(){
        dataTest.validateDateFormat("01/01/1599");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMes4(){
        dataTest.validateDateFormat("31/04/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes6(){
        dataTest.validateDateFormat("31/06/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes9(){
        dataTest.validateDateFormat("31/09/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes11(){
        dataTest.validateDateFormat("31/11/2022");
    }
    @Test
    public void testeMenorMes4() {
        assertEquals("29/04/2019", dataTest.getNextDate("28/04/2019"));
    }
    @Test
    public void testeMenorMes6() {
        assertEquals("29/06/2019", dataTest.getNextDate("28/06/2019"));
    }
    @Test
    public void testeMenorMes9() {
        assertEquals("29/09/2019", dataTest.getNextDate("28/09/2019"));
    }
    @Test
    public void testeMenorMes11() {
        assertEquals("29/11/2019", dataTest.getNextDate("28/11/2019"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao(){
        dataTest.validateDateFormat("ww/ww/wwww");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao2(){
        dataTest.validateDateFormat("ww.11/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao3(){
        dataTest.validateDateFormat("22.01.2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao4(){
        dataTest.validateDateFormat("0/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao5(){
        dataTest.validateDateFormat("01/0/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao6(){
        dataTest.validateDateFormat("01/01/150");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao7(){
        dataTest.validateDateFormat("01/01/1500");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao9(){
        dataTest.validateDateFormat("202/2");
    }
    
   
    @Test(expected = IllegalArgumentException.class)
    public void testMissingSlashInDate() {
        dataTest.validateDateFormat("01012022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFormat() {
        dataTest.validateDateFormat("01-01-2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLettersInDate() {
        dataTest.validateDateFormat("01/AB/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFormat() {
        dataTest.validateDateFormat("01.01/2222");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testValidDate() {
        dataTest.validateDateFormat("ww/ww/wwww");
    }

    @Test
    public void testNextDate() {
        assertEquals("02/01/2022", dataTest.getNextDate("01/01/2022"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoSlashPresent() {
        dataTest.validateDateFormat("01012022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectSlashUsage() {
        dataTest.validateDateFormat("ww.ww.wwww");
    }
    @Test
    public void testIsLeapYear() {
        assertTrue(dataTest.isLeapYear(2020));
        assertFalse(dataTest.isLeapYear(2021));
        assertFalse(dataTest.isLeapYear(1900));
        assertTrue(dataTest.isLeapYear(2024));
    }
}
