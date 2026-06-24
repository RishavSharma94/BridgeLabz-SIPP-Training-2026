import java.util.Scanner;

public class RestaurantBillingSystem {

    // Method to calculate food cost
    public static double calculateFoodCost(double price, int quantity) {
        return price * quantity;
    }

    // Method to calculate GST (5%)
    public static double calculateGST(double amount) {
        return amount * 0.05;
    }

    // Method to calculate discount (10% if bill > 1000)
    public static double calculateDiscount(double amount) {
        if (amount > 1000) {
            return amount * 0.10;
        }
        return 0;
    }

    // Method to generate final bill
    public static double generateFinalBill(double foodCost, double gst, double discount) {
        return foodCost + gst - discount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter food price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        double foodCost = calculateFoodCost(price, quantity);
        double gst = calculateGST(foodCost);
        double discount = calculateDiscount(foodCost);
        double finalBill = generateFinalBill(foodCost, gst, discount);

        System.out.println("\nFood Cost: ₹" + foodCost);
        System.out.println("GST: ₹" + gst);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Bill: ₹" + finalBill);

        sc.close();
    }
}