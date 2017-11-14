import java.text.NumberFormat;
import java.util.Locale;

public class JavaCurrencyFormatter {

    public static void printFormatted(final double value) {
        System.out.printf("US: %s\n", NumberFormat.getCurrencyInstance(Locale.US).format(value));
        NumberFormat rsFormat = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        System.out.printf("India: %s\n", rsFormat.format(value));
        System.out.printf("China: %s\n", NumberFormat.getCurrencyInstance(Locale.CHINA).format(value));
        System.out.printf("France: %s", NumberFormat.getCurrencyInstance(Locale.FRANCE).format(value));
    }
}
