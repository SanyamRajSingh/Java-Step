package week5.practice_problems;

public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = 0; // PIN not set initially
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public boolean setPin(int oldPin, int newPin) {
        if (pin == 0 || pin == oldPin) {
            pin = newPin;
            System.out.println("PIN set or changed successfully.");
            return true;
        }
        System.out.println("Incorrect old PIN.");
        return false;
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked.");
            return false;
        }
        if (enteredPin == pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public void unlockAccount(int correctPin) {
        if (correctPin == pin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked.");
        } else {
            System.out.println("Wrong PIN. Cannot unlock account.");
        }
    }

    public boolean deposit(double amount, int pin) {
        if (!validatePin(pin)) return false;
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
        balance += amount;
        System.out.println("Deposited " + amount);
        return true;
    }

    public boolean withdraw(double amount, int pin) {
        if (!validatePin(pin)) return false;
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }
        if (balance < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount);
        return true;
    }

    public boolean transfer(SecureBankAccount target, double amount, int pin) {
        if (!validatePin(pin)) return false;
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive.");
            return false;
        }
        if (balance < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        target.balance += amount;
        System.out.println("Transferred " + amount + " to account " + target.getAccountNumber());
        return true;
    }

    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked after multiple invalid PIN attempts.");
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        System.out.println("Invalid PIN attempt " + failedAttempts);
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("AB123", 1000);
        SecureBankAccount acc2 = new SecureBankAccount("XY789", 500);

        acc1.setPin(0, 1111);
        acc2.setPin(0, 2222);

        acc1.deposit(200, 1111);
        System.out.println("Balance acc1: " + acc1.getBalance());

        acc1.withdraw(100, 1111);
        System.out.println("Balance acc1: " + acc1.getBalance());

        acc1.transfer(acc2, 300, 1111);
        System.out.println("Balance acc1: " + acc1.getBalance());
        System.out.println("Balance acc2: " + acc2.getBalance());

        acc1.withdraw(50, 1234); // wrong PIN attempt 1
        acc1.withdraw(50, 1234); // wrong PIN attempt 2
        acc1.withdraw(50, 1234); // wrong PIN attempt 3 - account locked

        acc1.withdraw(50, 1111); // should fail - locked account

        acc1.unlockAccount(1111); // unlock with correct PIN

        acc1.withdraw(50, 1111); // should succeed
        System.out.println("Balance acc1: " + acc1.getBalance());
    }
}
