public class ChargingStationSystem {

    static int totalStations = 0;
    static double electricityRate = 10;

    String stationId;
    double unitsConsumed;

    ChargingStationSystem(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    void displayStationDetails() {
        System.out.println(stationId + " " + unitsConsumed + " " + calculateBill());
    }

    public static void main(String[] args) {

        ChargingStationSystem[] stations = new ChargingStationSystem[5];

        stations[0] = new ChargingStationSystem("S1", 50);
        stations[1] = new ChargingStationSystem("S2", 60);
        stations[2] = new ChargingStationSystem("S3", 70);
        stations[3] = new ChargingStationSystem("S4", 80);
        stations[4] = new ChargingStationSystem("S5", 90);

        for (ChargingStationSystem s : stations) {
            s.displayStationDetails();
        }

        electricityRate = 12;

        System.out.println("After rate change");

        for (ChargingStationSystem s : stations) {
            s.displayStationDetails();
        }
    }
}