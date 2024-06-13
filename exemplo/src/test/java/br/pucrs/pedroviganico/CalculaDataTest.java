package br.pucrs.pedroviganico;

import org.junit.Test;
import static org.junit.Assert.*;


public class CalculaDataTest {
    CalculaData dataTest = new CalculaData();
    @Test
    public void testGetNextDate_validDate() {
        assertEquals("02/01/2021", dataTest.proximData("01/01/2021"));
    }

    @Test
    public void testProximaData_FinalDeMes() {
        assertEquals("01/02/2021", dataTest.proximData("31/01/2021"));
    }

    @Test
    public void testProximadata_FinalDeAno() {
        assertEquals("01/01/2022", dataTest.proximData("31/12/2021"));
    }

    @Test
    public void testProximaData_leapYear() {
        assertEquals("29/02/2020", dataTest.proximData("28/02/2020"));
    }

    @Test
    public void testProximaData_nonLeapYear() {
        assertEquals("01/03/2019", dataTest.proximData("28/02/2019"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tetsProximaData_DataInvalida() {
        dataTest.proximData("32/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNextDate_invalidCharacters() {
        dataTest.proximData("abcd/ef/ghij");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFortmatoData_TamanhoInvalido() {
        dataTest.proximData("1/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_FormatoInvalido() {
        dataTest.proximData("01-01-2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_DiaInvalido() {
        dataTest.proximData("32/01/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateDateFormat_invalidMonth() {
        dataTest.proximData("01/13/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_DiaInvalidoFevereiro_nonLeapYear() {
        dataTest.proximData("29/02/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_DiaInvalidoFevereiro_LeapYear() {
        dataTest.proximData("30/02/2020");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_DiaInvalidoAbril() {
        dataTest.proximData("31/04/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_AnoInvalido() {
        dataTest.proximData("01/01/1599");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_TamanhoInvalido() {
        dataTest.proximData("01/1/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_TamanhoInvalido2() {
        dataTest.proximData("01/01/21");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarFormatoData_TamanhoInvalido3() {
        dataTest.proximData("01/01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaDiaMaior(){
        dataTest.validarFormatoData("35/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMesMaior(){
        dataTest.validarFormatoData("01/13/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaAnoMaior(){
        dataTest.validarFormatoData("01/01/9999");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaDiaMenor(){
        dataTest.validarFormatoData("00/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMesMenor(){
        dataTest.validarFormatoData("01/00/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaAnoMenor(){
        dataTest.validarFormatoData("01/01/1599");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaMes4(){
        dataTest.validarFormatoData("31/04/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes6(){
        dataTest.validarFormatoData("31/06/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes9(){
        dataTest.validarFormatoData("31/09/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaMes11(){
        dataTest.proximData("31/11/2022"); ////iwdjaiwdjaowdjw
    }
    @Test
    public void testeMenorMes4() {
        assertEquals("29/04/2019", dataTest.proximData("28/04/2019"));
    }
    @Test
    public void testeMenorMes6() {
        assertEquals("29/06/2019", dataTest.proximData("28/06/2019"));
    }
    @Test
    public void testeMenorMes9() {
        assertEquals("29/09/2019", dataTest.proximData("28/09/2019"));
    }
    @Test
    public void testeMenorMes11() {
        assertEquals("29/11/2019", dataTest.proximData("28/11/2019"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao(){
        dataTest.validarFormatoData("ww/ww/wwww");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao2(){
        dataTest.validarFormatoData("ww.11/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao3(){
        dataTest.validarFormatoData("22.01.2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao4(){
        dataTest.validarFormatoData("0/01/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao5(){
        dataTest.validarFormatoData("01/0/2022");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao6(){
        dataTest.validarFormatoData("01/01/150");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao7(){
        dataTest.validarFormatoData("01/01/1500");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testaValidacao9(){
        dataTest.validarFormatoData("202/2");
    }
    

    @Test(expected = IllegalArgumentException.class)
    public void tracoNaData() {
        dataTest.validarFormatoData("01-01-2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLetrasNaData() {
        dataTest.validarFormatoData("01/AB/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFormatoInvalido() {
        dataTest.validarFormatoData("01.01/2222");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLetras() {
        dataTest.validarFormatoData("ww/ww/wwww");
    }

    @Test
    public void testProximadata() {
        assertEquals("02/01/2022", dataTest.proximData("01/01/2022"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDataSemBarra() {
        dataTest.validarFormatoData("01012022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFormatoDataInvalido() {
        dataTest.validarFormatoData("ww.ww.wwww");
    }
    @Test
    public void testIsLeapYear() {
        assertTrue(dataTest.isLeapYear(2020));
        assertFalse(dataTest.isLeapYear(2021));
        assertFalse(dataTest.isLeapYear(1900));
        assertTrue(dataTest.isLeapYear(2024));
    }
}
