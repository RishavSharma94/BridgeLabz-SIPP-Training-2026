import java.util.Scanner;

public class WarehouseStockRecoverySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int[] stock = new int[n];
        int zeroIndex = -1;
        int sum = 0, count = 0;

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter stock of product " + (i + 1) + ": ");
            stock[i] = sc.nextInt();

            if (stock[i] == 0) {
                zeroIndex = i;
            } else {
                sum += stock[i];
                count++;
            }
        }

        double avg = sum / (double) count;

        // Replace zero with average
        if (zeroIndex != -1) {
            stock[zeroIndex] = (int) avg;
        }

        System.out.println("\nMissing stock was at position: " + (zeroIndex + 1));
        System.out.println("Average stock: " + avg);

        System.out.println("Updated Stock:");
        for (int i = 0; i < n; i++) {
            System.out.print(stock[i] + " ");
        }

        sc.close();
    }
}