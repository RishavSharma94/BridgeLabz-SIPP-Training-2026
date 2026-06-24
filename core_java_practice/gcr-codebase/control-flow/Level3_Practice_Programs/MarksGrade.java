import java.util.Scanner;

public class MarksGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        double physics = scanner.nextDouble();
        System.out.print("Enter marks for Chemistry: ");
        double chemistry = scanner.nextDouble();
        System.out.print("Enter marks for Maths: ");
        double maths = scanner.nextDouble();

        if (physics < 0 || chemistry < 0 || maths < 0) {
            System.out.println("Marks must be non-negative.");
            return;
        }

        double total = physics + chemistry + maths;
        double average = total / 3.0;
        String grade;
        String remarks;

        if (average >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Level 2, below but approaching agency-normalized standards";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (average >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        System.out.println("Average Marks: " + String.format("%.2f", average));
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
