// PaymentProcessor.java  (Target Interface)
public interface PaymentProcessor {
    void processPayment(double amount);
}

// ── Adaptee classes (third-party gateways with their OWN method names) ──

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("PayPal: Processing payment of $" + amount);
    }
}

class StripeGateway {
    public void chargeCard(double amount) {
        System.out.println("Stripe: Charging card $" + amount);
    }
}

class RazorpayGateway {
    public void pay(double amount) {
        System.out.println("Razorpay: Initiating payment of ₹" + amount);
    }
}
