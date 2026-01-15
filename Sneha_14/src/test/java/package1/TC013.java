
package package1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TC013 {

    /**
     * Computes warranty expiry date from purchase date and warranty period in years/months.
     */
    public static LocalDate getWarrantyExpiry(LocalDate purchaseDate, int warrantyYears, int warrantyMonths) {
        if (purchaseDate == null) throw new IllegalArgumentException("Purchase date must not be null.");
        if (warrantyYears < 0 || warrantyMonths < 0) {
            throw new IllegalArgumentException("Warranty years/months must be non-negative.");
        }
        Period warranty = Period.of(warrantyYears, warrantyMonths, 0);
        return purchaseDate.plus(warranty);
    }

    // Helper: parse dd/MM/yyyy or yyyy-MM-dd
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
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Exercise 13: Warranty Expiry Calculation ===");
        System.out.println("Enter purchase date (dd/MM/yyyy or yyyy-MM-dd): ");
        String dateInput = sc.nextLine();

        LocalDate purchaseDate;
        try {
            purchaseDate = parseDate(dateInput);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            sc.close();
            return;
        }

        System.out.print("Enter warranty period in years: ");
        int years = sc.nextInt();

        System.out.print("Enter warranty period in months: ");
        int months = sc.nextInt();

        LocalDate expiryDate = getWarrantyExpiry(purchaseDate, years, months);

        System.out.println("\nPurchase Date : " + purchaseDate);
        System.out.println("Warranty      : " + years + " years, " + months + " months");
        System.out.println("Expiry Date   : " + expiryDate);

        sc.close();
    }
}
