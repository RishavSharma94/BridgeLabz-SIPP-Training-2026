import java.util.Scanner;

public class RajsResultGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] marks = new int[5];
        int sum = 0;

        // Input marks
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks of subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            sum += marks[i];
        }

        double avg = sum / 5.0;
        char grade;

        // Grade using switch
        switch ((int) avg / 10) {
            case 9:
            case 10:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }

        System.out.println("\nAverage: " + avg);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}