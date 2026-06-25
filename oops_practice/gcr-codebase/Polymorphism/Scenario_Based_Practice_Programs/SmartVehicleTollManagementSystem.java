public class SmartVehicleTollManagementSystem {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("UP81A101", "Rishav"),
                new Bus("UP81B202", "Aman"),
                new Truck("UP81C303", "Rahul"),
                new Car("UP81D404", "Kunal")
        };

        calculateTotalRevenue(vehicles);
        searchVehicle(vehicles, "UP81B202");
        displayHighestTollVehicle(vehicles);
        countVehiclesByType(vehicles);
    }

    public static void calculateTotalRevenue(Vehicle[] vehicles) {

        double revenue = 0;

        for (Vehicle vehicle : vehicles) {
            revenue += vehicle.calculateToll();
        }

        System.out.println("Total Revenue: ₹" + revenue);
    }

    public static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.vehicleNumber.equals(vehicleNumber)) {
                System.out.println("\nVehicle Found:");
                vehicle.displayDetails();
                return;
            }
        }

        System.out.println("Vehicle Not Found");
    }

    public static void displayHighestTollVehicle(Vehicle[] vehicles) {

        Vehicle highest = vehicles[0];

        for (Vehicle vehicle : vehicles) {

            if (vehicle.calculateToll() > highest.calculateToll()) {
                highest = vehicle;
            }
        }

        System.out.println("\nHighest Toll Vehicle:");
        highest.displayDetails();
    }

    public static void countVehiclesByType(Vehicle[] vehicles) {

        int cars = 0;
        int buses = 0;
        int trucks = 0;

        for (Vehicle vehicle : vehicles) {

            if (vehicle instanceof Car)
                cars++;
            else if (vehicle instanceof Bus)
                buses++;
            else if (vehicle instanceof Truck)
                trucks++;
        }

        System.out.println("\nCars: " + cars);
        System.out.println("Buses: " + buses);
        System.out.println("Trucks: " + trucks);
    }
}

abstract class Vehicle {

    String vehicleNumber;
    String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    abstract double calculateToll();

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Toll: ₹" + calculateToll());
    }
}

class Car extends Vehicle {

    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 100;
    }
}

class Bus extends Vehicle {

    public Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 250;
    }
}

class Truck extends Vehicle {

    public Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 400;
    }
}