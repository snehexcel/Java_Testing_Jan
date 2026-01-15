
package package1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TC_DateTime {

    public static void main(String[] args) {
        // Formatters (localized and custom)
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // 1) Instant (always UTC)
        Instant currenttime = Instant.now();
        System.out.println("Current Time (Instant, UTC): " + currenttime);

        // 2) LocalDate operations
        LocalDate now = LocalDate.now();
        LocalDate independence = LocalDate.of(1947, Month.AUGUST, 15);

        // Period between two dates (calendar-based Y/M/D)
        Period period = independence.until(now); // same as Period.between(independence, now)

        // Prints (raw and formatted examples)
        System.out.println("Now: " + now + " | formatted: " + formatter.format(now));
        System.out.println("Independence: " + independence + " | formatted: " + formatter1.format(independence));
        System.out.println("Tomorrow: " + now.plusDays(1));
        System.out.println("LastMonth: " + now.minusMonths(1));
        System.out.println("Leap Year?: " + now.isLeapYear());
        System.out.println("move to 30th day of month: " + now.withDayOfMonth(30));

        System.out.println("Period: " + period); // e.g., P78Y5M9D
        System.out.println("Days: " + period.getDays());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Years: " + period.getYears());

        // 4) Totals using ChronoUnit (absolute totals, not calendar decomposition)
        long totalDays = ChronoUnit.DAYS.between(independence, now);
        long totalMonths = ChronoUnit.MONTHS.between(independence, now);
        long totalYears = ChronoUnit.YEARS.between(independence, now);

        System.out.println("Total Days since Independence: " + totalDays);
        System.out.println("Total Months since Independence: " + totalMonths);
        System.out.println("Total Years since Independence: " + totalYears);

        // 5) Zoned date-times
        ZonedDateTime ct = ZonedDateTime.now(); // system default zone
        ZonedDateTime ctInParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        ZonedDateTime ctInIndia = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        System.out.println("System Default Time: " + ct);
        System.out.println("India Time (Asia/Kolkata): " + ctInIndia);
        System.out.println("Paris Time (Europe/Paris): " + ctInParis);

        // Show zones and offsets
        System.out.println("System Zone & Offset: " + ct.getZone() + " " + ct.getOffset());
        System.out.println("India Offset: " + ctInIndia.getOffset());
        System.out.println("Paris Offset: " + ctInParis.getOffset());

        // 6) Optional: formatted display
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss z");
        System.out.println("System (formatted): " + fmt.format(ct));
        System.out.println("India (formatted): " + fmt.format(ctInIndia));
        System.out.println("Paris (formatted): " + fmt.format(ctInParis));
    }
}
