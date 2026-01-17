
package package1;

import java.util.Scanner;

public class Lab3_3{

    static class EmployeeException extends Exception {
        public EmployeeException(String message) {
            super(message);
        }
    }
    static class Employee {
        private int id;
        private String name;
        private double salary;
        private String designation;
        private String insuranceScheme;

        public Employee(int id, String name, double salary, String designation) throws EmployeeException {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Employee name cannot be blank.");
            }
            if (designation == null || designation.trim().isEmpty()) {
                throw new IllegalArgumentException("Designation cannot be blank.");
            }
            validateSalary(salary);
            this.id = id;
            this.name = name.trim();
            this.salary = salary;
            this.designation = designation.trim();
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getSalary() { return salary; }
        public String getDesignation() { return designation; }
        public String getInsuranceScheme() { return insuranceScheme; }

        public void setSalary(double salary) throws EmployeeException {
            validateSalary(salary);
            this.salary = salary;
        }

        public void setInsuranceScheme(String insuranceScheme) {
            this.insuranceScheme = insuranceScheme;
        }

        private void validateSalary(double salary) throws EmployeeException {
            if (salary < 3000) {
                throw new EmployeeException("Salary is below the minimum threshold (3000). Provided: " + salary);
            }
        }

        @Override
        public String toString() {
            return "Employee {" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", designation='" + designation + '\'' +
                    ", insuranceScheme='" + (insuranceScheme == null ? "N/A" : insuranceScheme) + '\'' +
                    '}';
        }
    }
    interface EmployeeService {
        void determineInsuranceScheme(Employee emp);
    }
    static class EmployeeServiceImpl implements EmployeeService {
        @Override
        public void determineInsuranceScheme(Employee emp) {
            double sal = emp.getSalary();
            String desig = emp.getDesignation().toLowerCase();

            String scheme;
            if (sal >= 80000 || desig.contains("manager")) {
                scheme = "Scheme A (Premium)";
            } else if (sal >= 50000) {
                scheme = "Scheme B";
            } else if (sal >= 30000) {
                scheme = "Scheme C";
            } else {
                scheme = "No Scheme";
            }
            emp.setInsuranceScheme(scheme);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter Designation (Manager/Programmer/System Associate): ");
            String designation = sc.nextLine();

            // Construct employee (may throw EmployeeException if salary < 3000)
            Employee emp = new Employee(id, name, salary, designation);

            EmployeeService service = new EmployeeServiceImpl();
            service.determineInsuranceScheme(emp);

            System.out.println("\nEmployee Details:");
            System.out.println(emp);

        } catch (EmployeeException eex) {
            System.out.println("[Validation Error] " + eex.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println("[Input Error] Please enter numeric values for ID and Salary.");
        } catch (IllegalArgumentException iae) {
            System.out.println("[Input Error] " + iae.getMessage());
        } catch (Exception ex) {
            System.out.println("[Unexpected Error] " + ex.getMessage());
        } finally {
            sc.close();
        }
    }
}
