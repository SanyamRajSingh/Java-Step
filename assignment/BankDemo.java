package week8.assignment;

abstract class BankAccount {
    private final String accountNumber;
    protected double balance;

    protected BankAccount(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit failed: amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount + ", new balance = " + balance);
    }

    public abstract void calculateInterest(int months);

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private final double annualRate; // e.g., 6% = 0.06

    public SavingsAccount(String acc, double opening, double annualRate) {
        super(acc, opening);
        this.annualRate = annualRate;
    }

    @Override
    public void calculateInterest(int months) {
        if (months <= 0) {
            System.out.println("Savings: months must be > 0");
            return;
        }
        double monthlyRate = annualRate / 12.0;
        double interest = balance * monthlyRate * months;
        balance += interest;
        System.out.printf("Savings interest for %d months = %.2f, new balance = %.2f%n",
                months, interest, balance);
    }
}

class CurrentAccount extends BankAccount {
    private final double monthlyFee;

    public CurrentAccount(String acc, double opening, double monthlyFee) {
        super(acc, opening);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void calculateInterest(int months) {
        if (months <= 0) {
            System.out.println("Current: months must be > 0");
            return;
        }
        double totalFees = monthlyFee * months;
        balance -= totalFees;
        System.out.printf("Current account charges for %d months = %.2f, new balance = %.2f%n",
                months, totalFees, balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA-001", 10000, 0.06);
        sa.deposit(2000);
        sa.calculateInterest(6);

        System.out.println();

        CurrentAccount ca = new CurrentAccount("CA-101", 15000, 150);
        ca.deposit(1000);
        ca.calculateInterest(6);
    }
}
