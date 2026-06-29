// ObserverTest.java
public class ObserverTest {
    public static void main(String[] args) {

        StockMarket apple = new StockMarket("AAPL");

        Observer mobile1 = new MobileApp("Alice");
        Observer mobile2 = new MobileApp("Bob");
        Observer web     = new WebApp();

        // Register observers
        apple.registerObserver(mobile1);
        apple.registerObserver(mobile2);
        apple.registerObserver(web);

        apple.setPrice(175.50);   // all 3 get notified

        // Bob deregisters
        System.out.println("\nBob deregisters...");
        apple.deregisterObserver(mobile2);

        apple.setPrice(180.00);   // only Alice and WebApp notified
    }
}
