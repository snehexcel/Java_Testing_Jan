package package1;
 
import java.util.Scanner;
 
public class Lab2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter Employee ID: ");
        int id = Integer.parseInt(sc.nextLine());
 
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
 
        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(sc.nextLine());
 
        System.out.print("Enter Designation (Manager/Programmer/System Associate): ");
        String designation = sc.nextLine();
 
        Employee emp = new Employee(id, name, salary, designation);
 
        EmployeeService service = new EmployeeServiceImpl();
        service.determineInsuranceScheme(emp);
 
        System.out.println("\nEmployee Details:");
        System.out.println(emp);
    }
}
 
 
 