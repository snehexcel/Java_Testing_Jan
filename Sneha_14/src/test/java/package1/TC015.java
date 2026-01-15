
package package1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class TC015 {

    /**
     * Calculates age as a Period (years, months, days) given date of birth.
     */
    public static Period calculateAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) throw new IllegalArgumentException("Date of birth must not be null.");
        LocalDate today = LocalDate.now();
        if (dateOfBirth.isAfter(today)) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }
        return Period.between(dateOfBirth, today);
    }

    /**
     * Builds a nicely capitalized full name "First Last" from given parts.
     * Handles null/blank inputs gracefully.
     */
    public static String getFullName(String firstName, String lastName) {
        String f = capWords(firstName);
        String l = capWords(lastName);
        if (f.isEmpty() && l.isEmpty()) return "";
        if (f.isEmpty()) return l;
        if (l.isEmpty()) return f;
        return f + " " + l;
    }

    private static String capWords(String s) {
        if (s == null) return "";
        String t = s.trim();
        if (t.isEmpty()) return "";
        String[] parts = t.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (!p.isEmpty()) {
                sb.append(Character.toUpperCase(p.charAt(0)));
                if (p.length() > 1) sb.append(p.substring(1));
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }

    // Helpers: parse dd/MM/yyyy or yyyy-MM-dd
    public static LocalDate parseDate(String text) {
        if (text == null) return null;
        text = text.trim();
        List<DateTimeFormatter> fmts = Arrays.asList(
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ISO_LOCAL_DATE
        );
        for (DateTimeFormatter f : fmts) {
            try { return LocalDate.parse(text, f); }
            catch (DateTimeParseException ignored) {}
        }
        throw new IllegalArgumentException(
                "Invalid date: " + text + ". Use dd/MM/yyyy or yyyy-MM-dd."
        );
    }

    public static void main(String[] args) {
        System.out.println("=== Exercise 15: Person Details ===");
        String fullName = getFullName("sneha", "kumari");
        LocalDate dob = parseDate("1998-09-01"); // adjust as needed
        Period age = calculateAge(dob);

        System.out.println("Full Name : " + fullName);
        System.out.println("DOB       : " + dob);
        System.out.printf("Age       : %d years, %d months, %d days%n",
                age.getYears(), age.getMonths(), age.getDays());

        // Optional: absolute totals
        long ageDays   = ChronoUnit.DAYS.between(dob, LocalDate.now());
        long ageMonths = ChronoUnit.MONTHS.between(dob, LocalDate.now());
        long ageYears  = ChronoUnit.YEARS.between(dob, LocalDate.now());
        System.out.println("Age (totals): " + ageYears + " years | " + ageMonths + " months | " + ageDays + " days");
    }
}
