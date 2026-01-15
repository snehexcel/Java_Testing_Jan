
package package1;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class TC014 {

    /**
     * Prints current date and time for the given zone id.
     */
    public static void printCurrentDateTimeForZone(String zoneId) {
        if (zoneId == null || zoneId.isBlank()) {
            throw new IllegalArgumentException("Zone ID must not be empty.");
        }
        try {
            ZoneId zone = ZoneId.of(zoneId.trim());
            ZonedDateTime now = ZonedDateTime.now(zone);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z VV");
            System.out.println("Zone   : " + zoneId);
            System.out.println("Current: " + now.format(fmt));
            System.out.println();
        } catch (Exception ex) {
            System.err.println("Invalid Zone ID: " + zoneId);
            System.err.println("Try one of these samples:");
            List<String> samples = Arrays.asList(
                "America/New_York", "Europe/London", "Asia/Tokyo",
                "US/Pacific", "Africa/Cairo", "Australia/Sydney",
                "Asia/Kolkata"
            );
            samples.forEach(s -> System.err.println("  - " + s));
            System.err.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exercise 14: Current Date-Time by Zone ===");
        printCurrentDateTimeForZone("America/New_York");
        printCurrentDateTimeForZone("Europe/London");
        printCurrentDateTimeForZone("Asia/Tokyo");
        printCurrentDateTimeForZone("US/Pacific");
        printCurrentDateTimeForZone("Africa/Cairo");
        printCurrentDateTimeForZone("Australia/Sydney");
        printCurrentDateTimeForZone("Asia/Kolkata");
    }
}
