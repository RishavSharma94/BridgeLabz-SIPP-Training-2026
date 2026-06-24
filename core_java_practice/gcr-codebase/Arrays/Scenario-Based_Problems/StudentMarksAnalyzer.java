import java.util.Scanner;

public class StudentMarksAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int sum = 0, countAbove75 = 0;

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            sum += marks[i];

            if (marks[i] > 75) {
                countAbove75++;
            }
        }

        int max = marks[0], min = marks[0];

        // Find max & min
        for (int i = 1; i < n; i++) {
            if (marks[i] > max) max = marks[i];
            if (marks[i] < min) min = marks[i];
        }

        double avg = sum / (double) n;

        System.out.println("\nHighest Marks: " + max);
        System.out.println("Lowest Marks: " + min);
        System.out.println("Students above 75: " + countAbove75);
        System.out.println("Average Marks: " + avg);

        System.out.println("Marks greater than average:");
        for (int i = 0; i < n; i++) {
            if (marks[i] > avg) {
                System.out.print(marks[i] + " ");
            }
        }

        sc.close();
    }
}