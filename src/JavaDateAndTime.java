import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

public class JavaDateAndTime {

    public static String getDay(String day, String month, String year) {
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))
                .getDayOfWeek()
                .name();
    }

    // Java 7 solution
    public static String getDay7(String day, String month, String year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
    }
}
