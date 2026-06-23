abstract class Vehicle {

    private String vehicleNumber;
    private String vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Type: " + vehicleType);
    }
}

class Car extends Vehicle {

    private double dailyRate;

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {

    private double dailyRate;

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {

    private double dailyRate;
    private double loadingCharge;

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setLoadingCharge(double loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    public double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        Car car = new Car();
        car.setVehicleNumber("UP32AB1234");
        car.setVehicleType("Car");
        car.setDailyRate(2000);

        Bike bike = new Bike();
        bike.setVehicleNumber("UP32XY5678");
        bike.setVehicleType("Bike");
        bike.setDailyRate(500);

        Truck truck = new Truck();
        truck.setVehicleNumber("UP32TR9999");
        truck.setVehicleType("Truck");
        truck.setDailyRate(4000);
        truck.setLoadingCharge(1000);

        int days = 3;

        car.displayDetails();
        System.out.println("Cost: " + car.calculateRentalCost(days));

        System.out.println();

        bike.displayDetails();
        System.out.println("Cost: " + bike.calculateRentalCost(days));

        System.out.println();

        truck.displayDetails();
        System.out.println("Cost: " + truck.calculateRentalCost(days));
    }
}