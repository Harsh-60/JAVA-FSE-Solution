// PayPalAdapter.java
public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal;

    public PayPalAdapter(PayPalGateway payPal) { this.payPal = payPal; }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);   // translates the call
    }
}

// StripeAdapter.java
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) { this.stripe = stripe; }

    @Override
    public void processPayment(double amount) {
        stripe.chargeCard(amount);
    }
}

// RazorpayAdapter.java
class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) { this.razorpay = razorpay; }

    @Override
    public void processPayment(double amount) {
        razorpay.pay(amount);
    }
}
