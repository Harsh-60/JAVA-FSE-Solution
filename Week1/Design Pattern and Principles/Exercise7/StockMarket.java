import java.util.ArrayList;
import java.util.List;

// Observer Interface
public interface Observer {
    void update(String stockName, double price);
}

// Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

// ── Concrete Subject ─────────────────────────────────────────────────────
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName) { this.stockName = stockName; }

    public void setPrice(double price) {
        System.out.println("\n[StockMarket] " + stockName + " price changed to $" + price);
        this.price = price;
        notifyObservers();
    }

    @Override public void registerObserver(Observer o)   { observers.add(o); }
    @Override public void deregisterObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

// ── Concrete Observers ───────────────────────────────────────────────────
class MobileApp implements Observer {
    private String userName;
    public MobileApp(String userName) { this.userName = userName; }

    @Override
    public void update(String stockName, double price) {
        System.out.println("  [MobileApp - " + userName + "] Alert: " + stockName + " = $" + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("  [WebApp] Dashboard updated: " + stockName + " = $" + price);
    }
}
