import java.util.Scanner;

public class DeliveryChargeSystem {

    // Method 1
    public static double calculateCharge(int distance) {
        return distance * 5;
    }

    // Method 2
    public static double calculateCharge(int distance, int weight) {
        return (distance * 5) + (weight * 2);
    }

    // Method 3
    public static double calculateCharge(int distance, int weight, boolean express) {
        double charge = (distance * 5) + (weight * 2);
        if (express) {
            charge += 50;
        }
        return charge;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance: ");
        int distance = sc.nextInt();

        System.out.print("Enter weight: ");
        int weight = sc.nextInt();

        System.out.print("Express delivery (true/false): ");
        boolean express = sc.nextBoolean();

        double charge = calculateCharge(distance, weight, express);

        System.out.println("\nDelivery Charge: ₹" + charge);

        sc.close();
    }
}