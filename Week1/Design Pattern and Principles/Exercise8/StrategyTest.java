// StrategyTest.java
public class StrategyTest {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Pay with Credit Card
        context.setStrategy(new CreditCardPayment("1234567890123456"));
        context.executePayment(250.00);

        // Switch to PayPal at runtime
        context.setStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(89.99);
    }
}
