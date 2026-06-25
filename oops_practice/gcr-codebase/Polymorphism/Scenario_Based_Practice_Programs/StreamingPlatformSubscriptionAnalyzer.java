public class StreamingPlatformSubscriptionAnalyzer {

    public static void main(String[] args) {

        Subscription[] subscriptions = {
                new BasicPlan("Rishav", "S101"),
                new PremiumPlan("Aman", "S102"),
                new FamilyPlan("Rahul", "S103"),
                new PremiumPlan("Ritika", "S104")
        };

        searchSubscription(subscriptions, "S102");

        System.out.println("\nNames Starting With R:");
        displaySubscribersByLetter(subscriptions, 'R');

        calculateTotalRevenue(subscriptions);
        displayMostExpensiveSubscription(subscriptions);
    }

    public static void searchSubscription(Subscription[] subscriptions, String id) {

        for (Subscription s : subscriptions) {

            if (s.subscriptionId.equals(id)) {
                System.out.println("Subscriber Found: " + s.subscriberName);
            }
        }
    }

    public static void displaySubscribersByLetter(Subscription[] subscriptions, char letter) {

        for (Subscription s : subscriptions) {

            if (s.subscriberName.startsWith(String.valueOf(letter))) {
                System.out.println(s.subscriberName);
            }
        }
    }

    public static void calculateTotalRevenue(Subscription[] subscriptions) {

        double total = 0;

        for (Subscription s : subscriptions) {
            total += s.calculateMonthlyCharge();
        }

        System.out.println("\nTotal Revenue: ₹" + total);
    }

    public static void displayMostExpensiveSubscription(Subscription[] subscriptions) {

        Subscription max = subscriptions[0];

        for (Subscription s : subscriptions) {

            if (s.calculateMonthlyCharge() > max.calculateMonthlyCharge()) {
                max = s;
            }
        }

        System.out.println("Most Expensive Subscriber: " + max.subscriberName);
    }
}

abstract class Subscription {

    String subscriberName;
    String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    abstract double calculateMonthlyCharge();
}

class BasicPlan extends Subscription {

    public BasicPlan(String name, String id) {
        super(name, id);
    }

    double calculateMonthlyCharge() {
        return 199;
    }
}

class PremiumPlan extends Subscription {

    public PremiumPlan(String name, String id) {
        super(name, id);
    }

    double calculateMonthlyCharge() {
        return 499;
    }
}

class FamilyPlan extends Subscription {

    public FamilyPlan(String name, String id) {
        super(name, id);
    }

    double calculateMonthlyCharge() {
        return 799;
    }
}