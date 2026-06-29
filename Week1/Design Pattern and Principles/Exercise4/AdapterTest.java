// AdapterTest.java
public class AdapterTest {
    public static void main(String[] args) {

        PaymentProcessor paypal   = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe   = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());

        // All called via the SAME interface
        paypal.processPayment(100.0);
        stripe.processPayment(200.0);
        razorpay.processPayment(1500.0);
    }
}
