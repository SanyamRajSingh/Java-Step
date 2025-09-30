package week8.practice_problem;

abstract class BankAccount {
    protected double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }
    public abstract void calculateInterest();
    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }
    public void calculateInterest() {
        System.out.println("Interest: " + (balance * 0.04));
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(double balance) {
        super(balance);
    }
    public void calculateInterest() {
        System.out.println("Interest: " + (balance * 0.02));
    }
}

public class BankTest {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(1000);
        acc1.displayBalance();
        acc1.calculateInterest();

        BankAccount acc2 = new CurrentAccount(2000);
        acc2.displayBalance();
        acc2.calculateInterest();
    }
}
