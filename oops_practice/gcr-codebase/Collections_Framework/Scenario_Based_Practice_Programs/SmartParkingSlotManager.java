import java.util.ArrayList;

public class SmartParkingSlotManager {

    public static void main(String[] args) {

        ParkingManager manager = new ParkingManager();

        manager.addVehicle("UP81AB1234");
        manager.addVehicle("DL01CD5678");
        manager.addVehicle("HR26EF9012");

        System.out.println();

        manager.searchVehicle("DL01CD5678");
        manager.searchVehicle("UP32XY0001");

        System.out.println();

        manager.removeVehicle("DL01CD5678");

        System.out.println();

        manager.displayVehicles();
    }
}

class ParkingManager {

    ArrayList<String> vehicles = new ArrayList<>();

    public void addVehicle(String vehicleNumber) {

        vehicles.add(vehicleNumber);
        System.out.println(vehicleNumber + " Entered Parking.");
    }

    public void removeVehicle(String vehicleNumber) {

        if (vehicles.remove(vehicleNumber)) {
            System.out.println(vehicleNumber + " Exited Parking.");
        } else {
            System.out.println("Vehicle Not Found.");
        }
    }

    public void searchVehicle(String vehicleNumber) {

        if (vehicles.contains(vehicleNumber)) {
            System.out.println(vehicleNumber + " is Currently Parked.");
        } else {
            System.out.println(vehicleNumber + " is Not Parked.");
        }
    }

    public void displayVehicles() {

        System.out.println("Parked Vehicles:");

        for (String vehicle : vehicles) {
            System.out.println(vehicle);
        }

        System.out.println("Occupied Parking Slots: " + vehicles.size());
    }
}