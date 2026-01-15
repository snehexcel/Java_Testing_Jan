
package package1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class TC011DateDays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US); // ensure consistent parsing behavior if needed

        // Supported input formats
        DateTimeFormatter[] formatters = new DateTimeFormatter[] {
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ISO_LOCAL_DATE // yyyy-MM-dd
        };

        System.out.println("Enter a date (supported formats: dd/MM/yyyy or yyyy-MM-dd):");
        String input = sc.nextLine().trim();

        LocalDate inputDate = parseDateWithFormats(input, formatters);
        if (inputDate == null) {
            System.err.println("Invalid date format. Examples: 15/08/1947 or 1947-08-15");
            sc.close();
            return;
        }

        LocalDate today = LocalDate.now();

        // Calendar-based difference (Y, M, D)
        Period period;
        boolean isFuture = inputDate.isAfter(today);
        if (isFuture) {
            period = Period.between(today, inputDate); // future date
        } else {
            period = Period.between(inputDate, today); // past date
        }

        // Absolute totals (not calendar components)
        long totalDays = Math.abs(ChronoUnit.DAYS.between(inputDate, today));
        long totalMonths = Math.abs(ChronoUnit.MONTHS.between(inputDate, today));
        long totalYears = Math.abs(ChronoUnit.YEARS.between(inputDate, today));

        System.out.println();
        System.out.println("Input Date : " + inputDate);
        System.out.println("Today      : " + today);
        System.out.println(isFuture ? "(The date is in the FUTURE relative to today.)"
                                     : "(The date is in the PAST relative to today.)");

        System.out.println();
        System.out.println("Calendar Duration (Years / Months / Days):");
        System.out.printf("  %d years, %d months, %d days%n",
                period.getYears(), period.getMonths(), period.getDays());

        System.out.println();
        System.out.println("Totals (absolute):");
        System.out.println("  Total years : " + totalYears);
        System.out.println("  Total months: " + totalMonths);
        System.out.println("  Total days  : " + totalDays);

        sc.close();
    }

    /**
     * Tries to parse a date string with multiple formatters.
     * Returns null if none match.
     */
    private static LocalDate parseDateWithFormats(String input, DateTimeFormatter[] formatters) {
        for (DateTimeFormatter fmt : formatters) {
            try {
                return LocalDate.parse(input, fmt);
            } catch (DateTimeParseException ignored) {
            }
        }
        return null;
    }
}
