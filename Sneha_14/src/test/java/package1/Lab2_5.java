package package1;
 
public class Lab2_5 {
    public static void main(String[] args) {
        Person1 smith = new Person1("Smith", "");
        Person1 kathy = new Person1("Kathy", "");
 
        Account sa = new SavingsAccount(smith, 2500.0);
        Account ca = new CurrentAccount(kathy, 3000.0, 2000.0);
 
        sa.deposit(500.0);
        boolean sOk = sa.withdraw(1800.0);
        boolean cOk1 = ca.withdraw(4500.0);
        boolean cOk2 = ca.withdraw(1000.0);
 
        System.out.println(sa + " | withdrawOk=" + sOk);
        System.out.println(ca + " | withdraw1Ok=" + cOk1 + ", withdraw2Ok=" + cOk2);
    }
}