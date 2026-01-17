package package1;
public class Lab3_1 {

    static class Employee {
        private int id;
        private String name;
        private double monthlySalary;

        public Employee(int id, String name, double monthlySalary) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Employee name cannot be blank.");
            }
            if (monthlySalary < 0) {
                throw new IllegalArgumentException("Monthly salary cannot be negative.");
            }
            this.id = id;
            this.name = name.trim();
            this.monthlySalary = monthlySalary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getMonthlySalary() { return monthlySalary; }

        public void setMonthlySalary(double monthlySalary) {
            if (monthlySalary < 0) {
                throw new IllegalArgumentException("Monthly salary cannot be negative.");
            }
            this.monthlySalary = monthlySalary;
        }

        public double calculateAnnualCTC() {
            return monthlySalary * 12;
        }

        @Override
        public String toString() {
            return "Employee { " +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   ", monthlySalary=" + monthlySalary +
                   " }";
        }
    }
    static class Manager extends Employee {
        private double annualBonus;

        public Manager(int id, String name, double monthlySalary, double annualBonus) {
            super(id, name, monthlySalary);
            if (annualBonus < 0) {
                throw new IllegalArgumentException("Annual bonus cannot be negative.");
            }
            this.annualBonus = annualBonus;
        }

        public double getAnnualBonus() { return annualBonus; }

        public void setAnnualBonus(double annualBonus) {
            if (annualBonus < 0) {
                throw new IllegalArgumentException("Annual bonus cannot be negative.");
            }
            this.annualBonus = annualBonus;
        }
        @Override
        public double calculateAnnualCTC() {
            return super.calculateAnnualCTC() + annualBonus;
        }

        @Override
        public String toString() {
            return "Manager { " +
                   "id=" + getId() +
                   ", name='" + getName() + '\'' +
                   ", monthlySalary=" + getMonthlySalary() +
                   ", annualBonus=" + annualBonus +
                   " }";
        }
    }
    public static void main(String[] args) {
        System.out.println("=== Lab 3.1: Inheritance Demo (Employee -> Manager) ===");

        Employee e = new Employee(101, "Amit", 45000);
        Manager m = new Manager(201, "Neha", 80000, 150000);

        System.out.println("\n-- Objects --");
        System.out.println(e);
        System.out.println(m);

        System.out.println("\n-- Calculations --");
        System.out.printf("Employee Annual CTC: %.2f%n", e.calculateAnnualCTC());
        System.out.printf("Manager  Annual CTC: %.2f%n", m.calculateAnnualCTC());
        try {
            new Manager(202, "  ", 50000, 100000); 
        } catch (IllegalArgumentException ex) {
            System.out.println("\n[Validation] " + ex.getMessage());
        }
    }
}
