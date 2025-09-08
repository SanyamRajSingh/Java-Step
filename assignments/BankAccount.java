package assignments;

import java.util.Random;

public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    private static Random rand = new Random();

    // Default constructor with balance=0
    public BankAccount() {
        this("Unknown", 0);
    }

    // Constructor with account holder (random account number)
    public BankAccount(String accountHolder) {
        this(accountHolder, rand.nextInt(900000) + 100000); // Random 6-digit number
    }

    // Constructor with account holder and initial balance
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = rand.nextInt(900000) + 100000;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("Raj");
        BankAccount acc3 = new BankAccount("Isha", 5000);

        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();

        acc2.deposit(2000);
        acc3.withdraw(1500);
        acc3.withdraw(4000); // Should fail

        acc2.displayAccount();
        acc3.displayAccount();
    }
}
