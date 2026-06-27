public class SmartHealthcareMonitoringSystem {

    public static void main(String[] args) {

        String[] patientNames = {
                "Rishav",
                "Aman",
                "Rahul",
                "Kunal"
        };

        String[] patientIds = {
                "P101",
                "12A",
                "P202",
                "AB"
        };

        HealthMonitoringSystem system = new HealthMonitoringSystem();

        system.displayHealthTips();

        System.out.println();

        for (int i = 0; i < patientNames.length; i++) {

            System.out.println("Patient Name: " + patientNames[i]);
            System.out.println("Patient ID: " + patientIds[i]);

            if (HeartRateMonitor.isPatientIdValid(patientIds[i])) {

                system.monitorHeartRate();
                system.monitorTemperature();

                System.out.println("Health Report: Healthy");
            } else {

                System.out.println("Invalid Patient ID");
            }

            System.out.println();
        }
    }
}

interface HeartRateMonitor {

    void monitorHeartRate();

    default void displayHealthTips() {
        System.out.println("Maintain a healthy heart by exercising regularly.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId.startsWith("P") && patientId.length() == 4;
    }
}

interface TemperatureMonitor {

    void monitorTemperature();

    default void displayHealthTips() {
        System.out.println("Drink enough water and monitor body temperature.");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    @Override
    public void monitorHeartRate() {
        System.out.println("Heart Rate: 72 BPM");
    }

    @Override
    public void monitorTemperature() {
        System.out.println("Temperature: 98.6 °F");
    }

    @Override
    public void displayHealthTips() {

        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();

        System.out.println("Regular health checkups are recommended.");
    }
}