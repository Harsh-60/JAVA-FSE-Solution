// Notifier.java  (Component Interface)
public interface Notifier {
    void send(String message);
}

// ── Concrete Component ───────────────────────────────────────────────────
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

// ── Abstract Decorator ───────────────────────────────────────────────────
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);   // delegate to wrapped notifier
    }
}

// ── Concrete Decorators ──────────────────────────────────────────────────
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) { super(notifier); }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) { super(notifier); }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SLACK notification: " + message);
    }
}
