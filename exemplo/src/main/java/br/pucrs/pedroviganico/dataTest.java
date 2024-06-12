package br.pucrs.pedroviganico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class dataTest {
    
    private static DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public dataTest (){
        
    }
    public static String getNextDate(String dateStr) {
       
            validateDateFormat(dateStr);
            LocalDate date = LocalDate.parse(dateStr, dataFormato);
            LocalDate nextDate = date.plusDays(1);
            return nextDate.format(dataFormato);
        
    }

    public static void validateDateFormat(String dateStr) {


        String[] parts = dateStr.split("/");
        if (dateStr.length() > 10) {
            throw new IllegalArgumentException("ERRO: tamanho invalido.");
        }else if(dateStr.length() < 10) {
           throw new IllegalArgumentException("faltou um digito");
    
        }

        if (contemLetras(dateStr) == false) {
            
            if (dateStr.contains("/")) {
                if (!dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    throw new IllegalArgumentException("ERRO: ERRO:3 não utilizou '/'.");
                }
            } else {
                throw new IllegalArgumentException("ERRO: não utilizou '/'.");
            }

        }else{
            throw new IllegalArgumentException("ERRO: data invalida");
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

       

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("ERRO: data invalida4.");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("ERRO: data invalida5");
        }

        if(year > 9998 || year < 1600){
            throw new IllegalArgumentException("ERRO: data invalida6");
        }

        if (month == 2) {
            if (isLeapYear(year)) {
                if (day > 29) {
                    throw new IllegalArgumentException("ERRO: data invalida.");
                }
            } else {
                if (day > 28) {
                    throw new IllegalArgumentException("ERRO: data invalida.");
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                throw new IllegalArgumentException("ERRO: data invalida.");
            }
        }

        
        
    }

    public static boolean contemLetras(String data) {
       
        String regex = ".*[a-zA-Z]+.*";
        return data.matches(regex);
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)){
            return true;
        }
        else{
            return false;
        }
    }
}