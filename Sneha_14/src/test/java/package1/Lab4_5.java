package package1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab4_5{
    static class Employee {
        int id;
        String name;
        double salary;
        String designation;
        String insuranceScheme;

        Employee(int id, String name, double salary, String designation) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.designation = designation;
        }
        @Override
        public String toString() {
            return id + " - " + name + " - " + salary + " - " + designation + " - " + insuranceScheme;
        }
    }
    interface EmployeeService {
        void determineInsuranceScheme(Employee emp);
    }
    static class EmployeeServiceImpl implements EmployeeService {
        @Override
        public void determineInsuranceScheme(Employee emp) {
            double sal = emp.salary;
            String desig = emp.designation == null ? "" : emp.designation.toLowerCase();

            if (sal >= 80000 || desig.contains("manager"))      emp.insuranceScheme = "Scheme A";
            else if (sal >= 50000)                               emp.insuranceScheme = "Scheme B";
            else if (sal >= 30000)                               emp.insuranceScheme = "Scheme C";
            else                                                 emp.insuranceScheme = "No Scheme";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();
        Map<Integer, Employee> map = new HashMap<>();

        try {
            System.out.print("How many employees? ");
            int n = Integer.parseInt(sc.nextLine().trim());

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for Employee " + i);

                System.out.print("ID: ");
                int id = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Name: ");
                String name = sc.nextLine().trim();

                System.out.print("Salary: ");
                double salary = Double.parseDouble(sc.nextLine().trim());

                System.out.print("Designation (Manager/Programmer/System Associate): ");
                String designation = sc.nextLine().trim();

                Employee emp = new Employee(id, name, salary, designation);
                service.determineInsuranceScheme(emp); // same as Lab 2.3
                map.put(id, emp);
            }
            System.out.print("\nEnter Insurance Scheme to view (e.g., Scheme A/B/C or No Scheme): ");
            String queryScheme = sc.nextLine().trim();

            System.out.println("\nEmployees with '" + queryScheme + "':");
            boolean any = false;
            for (Employee e : map.values()) {
                if (e.insuranceScheme.equalsIgnoreCase(queryScheme)) {
                    System.out.println(e);
                    any = true;
                }
            }
            if (!any) System.out.println("No employees found for that scheme.");
            System.out.print("\nEnter Employee ID to delete: ");
            int delId = Integer.parseInt(sc.nextLine().trim());

            if (map.remove(delId) != null) {
                System.out.println("Employee " + delId + " deleted.");
            } else {
                System.out.println("Employee ID not found.");
            }

        } catch (NumberFormatException ex) {
            System.out.println("Please enter numeric values for ID/Salary.");
        } finally {
            sc.close();
        }
    }
}
