// DecoratorTest.java
public class DecoratorTest {
    public static void main(String[] args) {

        // Email only
        Notifier emailOnly = new EmailNotifier();
        System.out.println("-- Email only --");
        emailOnly.send("Server is down!");

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\n-- Email + SMS --");
        emailAndSMS.send("Disk space critical!");

        // Email + SMS + Slack (stacked decorators)
        Notifier allChannels = new SlackNotifierDecorator(
                                   new SMSNotifierDecorator(
                                       new EmailNotifier()));
        System.out.println("\n-- Email + SMS + Slack --");
        allChannels.send("System outage detected!");
    }
}
