package br.pucrs.pedroviganico;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validDate = false;
        String inputDate = null;

        while (!validDate) {
            System.out.println("Digite a data no formato: dd/MM/yyyy:");
            inputDate = scanner.nextLine();

            try {
                DateCalculator.validateDateFormat(inputDate);
                validDate = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            String nextDate = DateCalculator.getNextDate(inputDate);
            System.out.println("Data seguinte: " + nextDate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
