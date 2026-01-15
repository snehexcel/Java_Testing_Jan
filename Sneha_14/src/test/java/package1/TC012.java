package package1;
 
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
 
public class TC012 {
	
	static void cal(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);
 
        System.out.println("Years  : " + period.getYears());
        System.out.println("Months : " + period.getMonths());
        System.out.println("Days   : " + period.getDays());
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		
	        System.out.println("yyyy-MM-dd: ");
	        String input = sc.nextLine();
	        
	        System.out.println("yyyy-MM-dd: ");
	        String input2 = sc.nextLine();	
	        
	        LocalDate inputDate = LocalDate.parse(input);
	        LocalDate inputData2 = LocalDate.parse(input2);
	
	        cal(inputDate, inputData2);
	
	        sc.close();
	}
 
}
 
 