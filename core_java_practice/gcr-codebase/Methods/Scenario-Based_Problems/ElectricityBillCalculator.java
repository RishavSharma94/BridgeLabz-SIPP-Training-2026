import java.util.Scanner;

public class ElectricityBillCalculator {

    // Method to calculate bill
    public static double calculateBill(int units) {
        double bill;

        if (units <= 100) {
            bill = units * 1.5;
        } else if (units <= 300) {
            bill = 100 * 1.5 + (units - 100) * 2.5;
        } else {
            bill = 100 * 1.5 + 200 * 2.5 + (units - 300) * 4;
        }

        return bill;
    }

    // Method to display bill
    public static void displayBill(int units, double amount) {
        System.out.println("\nUnits Consumed: " + units);
        System.out.println("Total Bill: ₹" + amount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        double billAmount = calculateBill(units);
        displayBill(units, billAmount);

        sc.close();
    }
}