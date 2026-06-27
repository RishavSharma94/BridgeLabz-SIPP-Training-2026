public class MultiServiceSmartTV {

    public static void main(String[] args) {

        String[] movies = {
                "Avengers",
                "Inception",
                "Interstellar"
        };

        String[] games = {
                "FIFA 25",
                "GTA V",
                "Minecraft"
        };

        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();

        System.out.println("\nAvailable Movies:");
        for (String movie : movies) {
            tv.streamContent(movie);
        }

        System.out.println("\nAvailable Games:");
        for (String game : games) {
            tv.playGame(game);
        }
    }
}

interface StreamingService {

    void streamContent(String movie);

    default void showSubscriptionDetails() {
        System.out.println("Streaming Subscription Active");
    }
}

interface GamingService {

    void playGame(String game);

    default void showSubscriptionDetails() {
        System.out.println("Gaming Subscription Active");
    }
}

class SmartTV implements StreamingService, GamingService {

    @Override
    public void streamContent(String movie) {
        System.out.println("Streaming: " + movie);
    }

    @Override
    public void playGame(String game) {
        System.out.println("Playing: " + game);
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
        System.out.println("Smart TV supports both Streaming and Gaming.");
    }
}