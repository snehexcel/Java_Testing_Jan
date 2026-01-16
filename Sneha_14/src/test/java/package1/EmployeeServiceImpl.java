package package1;
 
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void determineInsuranceScheme(Employee employee) {
        double salary = employee.getSalary();
        String designation = employee.getDesignation();
 
        if (salary > 50000 && designation.equalsIgnoreCase("Manager")) {
            employee.setInsuranceScheme("Scheme A");
        } else if (salary >= 30000 && salary <= 50000 && designation.equalsIgnoreCase("Programmer")) {
            employee.setInsuranceScheme("Scheme B");
        } else if (salary >= 20000 && salary < 30000 && designation.equalsIgnoreCase("System Associate")) {
            employee.setInsuranceScheme("Scheme C");
        } else {
            employee.setInsuranceScheme("No Scheme");
        }
    }
}
 