package br.pucrs.pedroviganico;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Data {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validDate = false;
        String inputDate = null;
        CalculaData data = new CalculaData();

        while (!validDate) {
            System.out.println("Digite a data no formato: dd/MM/yyyy:");
            inputDate = scanner.nextLine();

            try {
                data.validarFormatoData(inputDate);
                validDate = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            String nextDate = data.proximData(inputDate);
            System.out.println("Data seguinte: " + nextDate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
