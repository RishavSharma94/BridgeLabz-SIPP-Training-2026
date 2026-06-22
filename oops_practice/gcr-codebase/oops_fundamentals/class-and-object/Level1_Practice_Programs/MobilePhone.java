class MobilePhone {

    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void display() {
        System.out.println("Brand: " + brand +
                " | Model: " + model +
                " | Price: " + price);
    }
}

public class MobilePhone {

    public static void main(String[] args) {

        MobilePhone m1 = new MobilePhone("Samsung", "S23", 75000);
        MobilePhone m2 = new MobilePhone("Apple", "iPhone 14", 90000);

        m1.display();
        m2.display();
    }
}