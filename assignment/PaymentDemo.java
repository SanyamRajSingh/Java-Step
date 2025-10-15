package week9.assignment;

interface Discount {
    double calculate(double amount);
}

class Payment {
    public void processTransaction(double amount) {
        // Local inner class
        class Validator {
            boolean isValid(double amt) { return amt > 0; }
        }
        Validator validator = new Validator();
        if (validator.isValid(amount)) {
            System.out.println("Valid Payment: " + amount);
            // Anonymous inner class for Discount
            Discount discount = new Discount() {
                public double calculate(double amt) { return amt * 0.9; }
            };
            System.out.println("Discounted amount: " + discount.calculate(amount));
        } else {
            System.out.println("Invalid Payment: " + amount);
        }
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        new Payment().processTransaction(1000);
        new Payment().processTransaction(-5);
    }
}
