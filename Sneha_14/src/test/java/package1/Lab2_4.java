package package1;
 
public class Lab2_4 {
    public static void main(String[] args) {
        Person1 smith = new Person1("Smith", "");
        Person1 kathy = new Person1("Kathy", "");
 
        Account savings = new SavingsAccount(smith, 2500.0);
        Account current = new CurrentAccount(kathy, 3000.0, 2000.0);
 
        savings.deposit(1000.0);
        boolean sWithdraw = savings.withdraw(1800.0);
 
        boolean cWithdraw1 = current.withdraw(4500.0);
        boolean cWithdraw2 = current.withdraw(1000.0);
 
        System.out.println("Savings Account:");
        System.out.println(savings);
        System.out.println("Withdraw Successful: " + sWithdraw);
 
        System.out.println("\nCurrent Account:");
        System.out.println(current);
        System.out.println("Withdraw 1 Successful: " + cWithdraw1);
        System.out.println("Withdraw 2 Successful: " + cWithdraw2);
    }
}
 