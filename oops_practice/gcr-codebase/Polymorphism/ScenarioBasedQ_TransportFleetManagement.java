public class ScenarioBasedQ_TransportFleetManagement {

    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car("Swift"),
                new Bus("Volvo"),
                new Bike("Pulsar"),
                new ElectricCar("Tesla")
        };

        int km = 100;

        for (Vehicle vehicle : fleet) {

            System.out.println("Vehicle: " + vehicle.getModel());
            System.out.println("Fuel Cost for " + km + " km = ₹" + vehicle.fuelCost(km));

            if (vehicle instanceof ElectricCar) {
                ElectricCar electricCar = (ElectricCar) vehicle;
                System.out.println("Type: Electric Car");
            } else if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.println("Type: Car");
            } else if (vehicle instanceof Bus) {
                Bus bus = (Bus) vehicle;
                System.out.println("Type: Bus");
            } else if (vehicle instanceof Bike) {
                Bike bike = (Bike) vehicle;
                System.out.println("Type: Bike");
            }

            System.out.println("------------------------");
        }
    }
}

abstract class Vehicle {

    protected String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public abstract double fuelCost(int km);
}

class Car extends Vehicle {

    public Car(String model) {
        super(model);
    }

    @Override
    public double fuelCost(int km) {
        return km * 6.0;
    }
}

class Bus extends Vehicle {

    public Bus(String model) {
        super(model);
    }

    @Override
    public double fuelCost(int km) {
        return km * 15.0;
    }
}

class Bike extends Vehicle {

    public Bike(String model) {
        super(model);
    }

    @Override
    public double fuelCost(int km) {
        return km * 2.5;
    }
}

class ElectricCar extends Vehicle {

    public ElectricCar(String model) {
        super(model);
    }

    @Override
    public double fuelCost(int km) {
        return km * 1.2;
    }
}