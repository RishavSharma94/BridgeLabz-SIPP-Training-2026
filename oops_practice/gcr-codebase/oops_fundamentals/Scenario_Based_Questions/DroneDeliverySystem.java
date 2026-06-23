public class DroneDeliverySystem {

    static String companyName = "SkyLogistics";

    String droneId;
    int batteryPercentage;

    DroneDeliverySystem(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    void startDelivery() {
        System.out.println(droneId + " started delivery");
    }

    void displayStatus() {
        System.out.println(droneId + " " + batteryPercentage + "% " + companyName);
    }

    public static void main(String[] args) {

        DroneDeliverySystem d1 = new DroneDeliverySystem("D1", 80);
        DroneDeliverySystem d2 = new DroneDeliverySystem("D2", 60);
        DroneDeliverySystem d3 = new DroneDeliverySystem("D3", 90);

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}