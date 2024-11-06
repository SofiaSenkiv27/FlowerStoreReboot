package flower.reboot.payment;

public class PayPalPaymentStrategy implements Payment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paying $" + amount + " with PayPal.");
        return true;
    }
}