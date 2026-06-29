// Logger.java
public class Logger {

    // Step 1: Private static instance of itself
    private static Logger instance;

    // Step 2: Private constructor — no one can do "new Logger()" from outside
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Public static method to get the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A sample logging method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
