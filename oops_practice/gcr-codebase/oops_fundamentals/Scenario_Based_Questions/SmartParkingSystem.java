public class SmartParkingSystem {

    String vehicleNumber;
    String ownerName;
    String vehicleType;

    SmartParkingSystem(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void displayCars(SmartParkingSystem[] vehicles) {
        for (SmartParkingSystem v : vehicles) {
            if (v.vehicleType.equals("Car")) {
                System.out.println(v.vehicleNumber + " " + v.ownerName);
            }
        }
    }

    static void displayBikes(SmartParkingSystem[] vehicles) {
        for (SmartParkingSystem v : vehicles) {
            if (v.vehicleType.equals("Bike")) {
                System.out.println(v.vehicleNumber + " " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {

        SmartParkingSystem[] vehicles = new SmartParkingSystem[10];

        vehicles[0] = new SmartParkingSystem("V1", "A", "Car");
        vehicles[1] = new SmartParkingSystem("V2", "B", "Bike");
        vehicles[2] = new SmartParkingSystem("V3", "C", "Car");
        vehicles[3] = new SmartParkingSystem("V4", "D", "Bike");
        vehicles[4] = new SmartParkingSystem("V5", "E", "Car");
        vehicles[5] = new SmartParkingSystem("V6", "F", "Bike");
        vehicles[6] = new SmartParkingSystem("V7", "G", "Car");
        vehicles[7] = new SmartParkingSystem("V8", "H", "Bike");
        vehicles[8] = new SmartParkingSystem("V9", "I", "Car");
        vehicles[9] = new SmartParkingSystem("V10", "J", "Bike");

        System.out.println("Cars:");
        displayCars(vehicles);

        System.out.println("Bikes:");
        displayBikes(vehicles);
    }
}