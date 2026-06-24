import java.util.Scanner;

public class ParkingLotSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int capacity = 5;
        int occupied = 0;
        int choice;

        while (true) {

            System.out.println("\n1. Park Car");
            System.out.println("2. Exit Car");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Exit System");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (occupied < capacity) {
                        occupied++;
                        System.out.println("Car Parked!");
                    } else {
                        System.out.println("Parking Full!");
                    }
                    break;

                case 2:
                    if (occupied > 0) {
                        occupied--;
                        System.out.println("Car Exited!");
                    } else {
                        System.out.println("Parking Empty!");
                    }
                    break;

                case 3:
                    System.out.println("Occupied: " + occupied + "/" + capacity);
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}