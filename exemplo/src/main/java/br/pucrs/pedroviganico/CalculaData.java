package br.pucrs.pedroviganico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CalculaData {
    
    private static DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public CalculaData (){
        
    }
    public static String proximData(String dataStr) {
       
            validarFormatoData(dataStr);
            LocalDate data = LocalDate.parse(dataStr, dataFormato);
            LocalDate nextDate = data.plusDays(1);
            return nextDate.format(dataFormato);
        
    }

    public static void validarFormatoData(String dataString) {


        String[] parts = dataString.split("/");
        if (dataString.length() > 10) {
            throw new IllegalArgumentException("ERRO: tamanho invalido.");
        }else if(dataString.length() < 10) {
           throw new IllegalArgumentException("ERRO: faltou um digito.");
    
        }

        if (contemLetras(dataString) == false) {
            
            if (dataString.contains("/")) {
                if (!dataString.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    throw new IllegalArgumentException("ERRO: não utilizou '/'.");
                }
            } else {
                throw new IllegalArgumentException("ERRO: não utilizou '/'.");
            }

        }else{
            throw new IllegalArgumentException("ERRO: data invalida");
        }

        int dia = Integer.parseInt(parts[0]);
        int mes = Integer.parseInt(parts[1]);
        int ano = Integer.parseInt(parts[2]);

       

        if (dia < 1 || dia > 31) {
            throw new IllegalArgumentException("ERRO: data invalida.");
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("ERRO: data invalida");
        }

        if(ano > 9998 || ano < 1600){
            throw new IllegalArgumentException("ERRO: data invalida");
        }

        if (mes == 2) {
            if (isLeapYear(ano)) {
                if (dia > 29) {
                    throw new IllegalArgumentException("ERRO: data invalida.");
                }
            } else {
                if (dia > 28) {
                    throw new IllegalArgumentException("ERRO: data invalida.");
                }
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) {
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