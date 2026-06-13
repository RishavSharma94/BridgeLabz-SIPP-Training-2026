import java.util.Scanner;

public class StoryBasedQ_KingdomTaxSystem {

    // Method to calculate tax
    public static double calculateTax(double income) {
        if (income < 10000) {
            return income * 0.05;
        } else if (income <= 50000) {
            return income * 0.15;
        } else {
            return income * 0.30;
        }
    }

    // Method to get tax bracket
    public static String getBracket(double income) {
        if (income < 10000) {
            return "Low Income (5%)";
        } else if (income <= 50000) {
            return "Middle Income (15%)";
        } else {
            return "High Income (30%)";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] citizens = new double[10];
        double totalTax = 0;

        System.out.println("👑 Welcome to the Kingdom Tax System 👑");

        // Input
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter income of citizen " + (i + 1) + ": ");
            citizens[i] = sc.nextDouble();
        }

        System.out.println("\n📜 Kingdom Tax Report 📜");

        // Processing
        for (int i = 0; i < citizens.length; i++) {
            double tax = calculateTax(citizens[i]);
            String bracket = getBracket(citizens[i]);

            totalTax += tax;

            System.out.println("\nCitizen " + (i + 1));
            System.out.println("Income: " + citizens[i] + " gold coins");
            System.out.println("Tax Bracket: " + bracket);
            System.out.println("Tax to be paid: " + tax + " gold coins");
        }

        // Total tax collected
        System.out.println("\n💰 Total Tax Collected in the Kingdom = " + totalTax + " gold coins");

        sc.close();
    }
}