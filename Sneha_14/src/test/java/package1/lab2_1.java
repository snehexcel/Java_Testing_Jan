package package1;
 
import java.util.*;

public class lab2_1 {
	
	public static class Person {
		
	    private String name;
	    private float age;
	
	    public Person(String name, float age) {
	        this.name = name;
	        this.age = age;
	    }
	
	    public String getName() {
	        return name;
	    }
	
	    public void setName(String name) {
	        this.name = name;
	    }
	
	    public float getAge() {
	        return age;
	    }
	
	    public void setAge(float age) {
	        this.age = age;
	    }
	}
	
	public static class Account {
		
	    private String accNum;
	    private double balance;
	    private Person accHolder;
	
	    private static final double MIN_BALANCE = 500.0;
	    public Account() {}
	    public Account(String accNum, Person accHolder, double balance) {
	        this.accNum = accNum;
	        this.accHolder = accHolder;
	
	        if (balance >= MIN_BALANCE) {
	            this.balance = balance;
	        } else {
	            this.balance = MIN_BALANCE;
	            System.out.println("Minimum balance ₹500 maintained.");
	        }
	    }
	
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	        }
	    }
	
	    public void withdraw(double amount) {
	        if (balance - amount >= MIN_BALANCE) {
	            balance -= amount;
	        } else {
	            System.out.println("Withdrawal denied! Minimum balance ₹500 must be maintained.");
	        }
	    }
	    
	    public static String generate() {
	    	long time = System.currentTimeMillis();
	    	int random = new Random().nextInt(900)+100;
	    	return time+""+random;
	    }
	
	    public double getBalance() {
	        return balance;
	    }
	
	    public String getAccNum() {
	        return accNum;
	    }
	
	    public void setAccNum(String accNum) {
	        this.accNum = accNum;
	    }
	
	    public Person getAccHolder() {
	        return accHolder;
	    }
	
	    public void setAccHolder(Person accHolder) {
	        this.accHolder = accHolder;
	    }
	}
 
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 Account a = new Account();
		   String ac = a.generate();
	        Person p = new Person("Rahul", 25);
	        Account acc = new Account(ac, p, 1000);
	        
	
	        System.out.print("Enter deposit amount: ");
	        double depositAmt = sc.nextDouble();
	        acc.deposit(depositAmt);
	
	        System.out.println("Balance: " + acc.getBalance());
	
	        System.out.print("Enter withdrawal amount: ");
	        double withdrawAmt = sc.nextDouble();
	        acc.withdraw(withdrawAmt);
	
	        System.out.println("Final Balance: " + acc.getBalance());
	        System.out.println(ac);
 
	}
 
}
 
 