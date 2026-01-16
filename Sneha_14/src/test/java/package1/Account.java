package package1;
 
import java.util.concurrent.atomic.AtomicLong;
 
public class Account {
    private static final AtomicLong SEQ = new AtomicLong(1000000000L);
 
    private final long accountNumber;
    private final Person1 holder;
    protected double balance;
 
    public Account(Person1 holder, double openingBalance) {
        this.accountNumber = SEQ.getAndIncrement();
        this.holder = holder;
        this.balance = openingBalance;
    }
 
    public long getAccountNumber() { return accountNumber; }
    public Person1 getHolder()     { return holder; }
    public double getBalance()     { return balance; }
 
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }
 
    // IMPORTANT: boolean return type for polymorphism
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
 
    @Override
    public String toString() {
        return getClass().getSimpleName() +
               "{acctNo=" + accountNumber +
               ", holder=" + holder +
               ", balance=INR " + String.format("%.2f", balance) + "}";
    }
}