
package package1;

public class Lab3_2 {

    // Interfaces
    interface Payable {
        double calculatePay();
    }

    interface Taxable {
        double calculateTax();
    }

    // Implementation class
    static class Contractor implements Payable, Taxable {
        private String name;
        private double hourlyRate;
        private int hours; // monthly hours

        public Contractor(String name, double hourlyRate, int hours) {
            if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be blank.");
            if (hourlyRate < 0 || hours < 0) throw new IllegalArgumentException("Rate/Hours cannot be negative.");
            this.name = name.trim();
            this.hourlyRate = hourlyRate;
            this.hours = hours;
        }

        @Override
        public double calculatePay() {
            return hourlyRate * hours;
        }

        @Override
        public double calculateTax() {
            double pay = calculatePay();
            return pay * 0.10; // flat 10% demo tax
        }

        @Override
        public String toString() {
            return "Contractor{name='" + name + "', hourlyRate=" + hourlyRate + ", hours=" + hours + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Lab 3.2: Interfaces (Payable, Taxable) ===");
        Contractor c = new Contractor("Ravi", 1200, 160);
        System.out.println(c);
        System.out.println("Monthly Pay: " + c.calculatePay());
        System.out.println("Estimated Tax: " + c.calculateTax());
    }
}
