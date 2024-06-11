import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateCalculator {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String getNextDate(String dateStr) throws IllegalArgumentException {
        try {
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
            throw new IllegalArgumentException("ERRO: formato invalido.");
        }
        String[] parts = dateStr.split("/");
        if (parts.length != 3 || parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
            throw new IllegalArgumentException("ERRO: formato invalido.");
        }
    }
}