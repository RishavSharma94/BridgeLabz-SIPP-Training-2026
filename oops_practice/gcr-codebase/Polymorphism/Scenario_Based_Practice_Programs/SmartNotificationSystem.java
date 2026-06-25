public class SmartNotificationSystem {

    public static void main(String[] args) {

        Notification[] notifications = {
                new EmailNotification("Rishav", "Welcome to Email Service"),
                new SMSNotification("Aman", "OTP is 1234"),
                new PushNotification("Rahul", "New Offer Available")
        };

        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}

class Notification {

    String recipientName;
    String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public void sendNotification() {
        System.out.println(message);
    }
}

class EmailNotification extends Notification {

    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Email sent to " + recipientName + ": " + message);
    }
}

class SMSNotification extends Notification {

    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("SMS sent to " + recipientName + ": " + message);
    }
}

class PushNotification extends Notification {

    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Push Notification sent to " + recipientName + ": " + message);
    }
}