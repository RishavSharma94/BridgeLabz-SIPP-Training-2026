import java.util.Scanner;

public class CinemaSeatAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat status (0=Empty, 1=Booked): ");
            seats[i] = sc.nextInt();
        }

        int maxLen = 0, currentLen = 0;
        int start = 0, tempStart = 0;
        int booked = 0, empty = 0;

        for (int i = 0; i < n; i++) {

            if (seats[i] == 0) {
                empty++;
                currentLen++;

                if (currentLen == 1) {
                    tempStart = i;
                }

                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    start = tempStart;
                }

            } else {
                booked++;
                currentLen = 0;
            }
        }

        int end = start + maxLen - 1;

        System.out.println("\nLongest empty block: " + maxLen);
        System.out.println("Start index: " + start);
        System.out.println("End index: " + end);

        System.out.println("Total booked seats: " + booked);
        System.out.println("Total empty seats: " + empty);

        if (maxLen >= 5) {
            System.out.println("Group of 5 can sit together.");
        } else {
            System.out.println("Group of 5 cannot sit together.");
        }

        sc.close();
    }
}