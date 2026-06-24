import java.util.Scanner;

public class MetroSmartCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance;
        System.out.print("Enter initial card balance: ");
        balance = sc.nextDouble();

        while (balance > 0) {

            System.out.print("\nEnter distance (km) or 0 to exit: ");
            int distance = sc.nextInt();

            if (distance == 0) {
                break;
            }

            // Fare calculation using ternary
            double fare = (distance <= 5) ? 10 :
                    (distance <= 10) ? 20 :
                            (distance <= 20) ? 30 : 40;

            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted: " + fare);
                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
        }

        System.out.println("\nThank you for using Metro Card!");
        sc.close();
    }
}