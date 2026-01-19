
package package1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Lab4_3{
    static class Employee {
        int id;
        String name;
        double salary;
        String designation;
        String scheme;

        Employee(int id, String name, double salary, String designation) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.designation = designation;
        }
    }
    static class EmployeeService {
        void determineScheme(Employee e) {
            String desigLower = e.designation == null ? "" : e.designation.toLowerCase();
            if (e.salary >= 80000 || desigLower.contains("manager"))      e.scheme = "Scheme A";
            else if (e.salary >= 50000)                                   e.scheme = "Scheme B";
            else if (e.salary >= 30000)                                   e.scheme = "Scheme C";
            else                                                           e.scheme = "No Scheme";
        }
        void writeToTextFile(List<Employee> list, String filePath) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) {
                bw.write("id,name,salary,designation,scheme");
                bw.newLine();
                for (Employee e : list) {
                    bw.write(csv(e.id) + "," + csv(e.name) + "," + csv(e.salary) + ","
                            + csv(e.designation) + "," + csv(e.scheme));
                    bw.newLine();
                }
            }
        }

        private String csv(Object v) {
            String s = String.valueOf(v == null ? "" : v);
            boolean needsQuote = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");
            if (s.contains("\"")) s = s.replace("\"", "\"\"");
            return needsQuote ? "\"" + s + "\"" : s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();
        List<Employee> employees = new ArrayList<>();

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

                System.out.print("Designation (e.g., Manager/Programmer/System Associate): ");
                String designation = sc.nextLine().trim();

                Employee e = new Employee(id, name, salary, designation);
                service.determineScheme(e);
                employees.add(e);
            }
            String filePath = "C:\\\\\\\\Users\\\\\\\\Sneha.3.Kumari\\\\\\\\git\\\\\\\\Java_Testing_Jan\\\\\\\\Sneha_14\\\\\\\\src\\\\\\\\test\\\\\\\\java\\\\\\\\package1\\\\\\\\employees.txt";

            service.writeToTextFile(employees, filePath);
            System.out.println("\n✅ Employee details saved to: " + filePath);
            System.out.println("Open it in Notepad to view (CSV format with header).");

        } catch (NumberFormatException nfe) {
            System.out.println("❌ Please enter valid numeric values for ID/Salary.");
        } catch (IOException ioe) {
            System.out.println("❌ I/O Error: " + ioe.getMessage());
        } catch (Exception ex) {
            System.out.println("❌ Unexpected Error: " + ex.getMessage());
        } finally {
            sc.close();
        }
}
}
