package package1;
 
public class SavingsAccount extends Account {
    public static final double MINIMUM_BALANCE = 1000.0;
 
    public SavingsAccount(Person1 holder, double openingBalance) {
        super(holder, openingBalance);
    }
 
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (balance - amount < MINIMUM_BALANCE) return false;
        balance -= amount;
        return true;
    }
}
 