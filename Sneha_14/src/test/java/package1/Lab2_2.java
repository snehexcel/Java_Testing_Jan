package package1;
 
public class Lab2_2 {
    public static void main(String[] args) {
        Person1 smith = new Person1("Smith", "");
        Person1 kathy = new Person1("Kathy", "");
 
        SavingsAccount sa = new SavingsAccount(smith, 2000.0);
        CurrentAccount ca = new CurrentAccount(kathy, 3000.0, 2000.0);
 
        sa.deposit(2000.0);
        boolean ok1 = ca.withdraw(2000.0);
 
        System.out.println("Updated Balances:");
        System.out.println(sa);
        System.out.println(ca);
        System.out.println("Kathy withdraw success: " + ok1);
    }
}