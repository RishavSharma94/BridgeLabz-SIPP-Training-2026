public class CarRental {

    String customerName;
    String carModel;
    int rentalDays;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateCost() {
        double perDay = 1000;
        return rentalDays * perDay;
    }

    void display() {
        System.out.println(customerName + " " + carModel + " " + calculateCost());
    }

    public static void main(String[] args) {
        CarRental c = new CarRental("Rishav", "Swift", 5);
        c.display();
    }
}