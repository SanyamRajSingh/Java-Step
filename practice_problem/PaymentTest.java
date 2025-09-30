package week8.practice_problem;

interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to Credit Card");
    }
}

class UPIPayment implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to UPI");
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        PaymentGateway pg1 = new CreditCardPayment();
        pg1.pay(500);
        pg1.refund(100);

        PaymentGateway pg2 = new UPIPayment();
        pg2.pay(600);
        pg2.refund(200);
    }
}
