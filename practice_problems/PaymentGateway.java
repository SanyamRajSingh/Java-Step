package week9.practice_problems;

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Credit card payment");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Wallet payment");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = { new CreditCardPayment(), new WalletPayment() };
        for (Payment p : payments) {
            System.out.println(p.getClass().getSimpleName());
            p.pay();
        }
    }
}
