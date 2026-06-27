public class ScenarioBasedQ_FitnessTracker {

    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity("Running - 5 km");
        device.generateReport();
        device.sendAlert();
        device.resetData();

        System.out.println();

        Trackable tracker = device;
        Reportable reporter = device;
        Notifiable notifier = device;

        tracker.logActivity("Cycling - 10 km");
        reporter.generateReport();
        notifier.sendAlert();

        System.out.println("\nFitnessDevice implements multiple interfaces successfully.");
        System.out.println("Java supports multiple inheritance using interfaces, not classes.");
    }
}

interface Trackable {

    void logActivity(String activity);

    default void resetData() {
        System.out.println("Fitness data has been reset.");
    }
}

interface Reportable {

    void generateReport();
}

interface Notifiable {

    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    private String lastActivity;

    @Override
    public void logActivity(String activity) {
        lastActivity = activity;
        System.out.println("Activity Logged: " + activity);
    }

    @Override
    public void generateReport() {
        System.out.println("Fitness Report");
        System.out.println("Latest Activity: " + lastActivity);
    }

    @Override
    public void sendAlert() {
        System.out.println("Alert: Time for your next workout!");
    }
}