package br.pucrs.pedroviganico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateCalculator {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String getNextDate(String dateStr) throws IllegalArgumentException {
        try {
            validateDateFormat(dateStr);
            LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);
            LocalDate nextDate = date.plusDays(1);
            return nextDate.format(DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("ERRO: data invalida.");
        }
    }

    public static void validateDateFormat(String dateStr) {
        if (dateStr.length() != 10) {
            throw new IllegalArgumentException("ERRO: tamanho invalido.");
        }
        if (!dateStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("ERRO: não utilizou '/.");
        }
        String[] parts = dateStr.split("/");
        if (parts.length != 3 || parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
            throw new IllegalArgumentException("ERRO: não utilizou digito.");
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("ERRO: mes invalido.");
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("ERRO: dia invalido.");
        }

        if(year > 9998 || year < 1600){
            throw new IllegalArgumentException("ERRO: Ano inválido");
        }

        if (month == 2) {
            if (isLeapYear(year)) {
                if (day > 29) {
                    throw new IllegalArgumentException("ERRO: dia invalido para fevereiro em ano bissexto.");
                }
            } else {
                if (day > 28) {
                    throw new IllegalArgumentException("ERRO: dia invalido para fevereiro.");
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                throw new IllegalArgumentException("ERRO: dia invalido para o mes.");
            }
        }

        
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}