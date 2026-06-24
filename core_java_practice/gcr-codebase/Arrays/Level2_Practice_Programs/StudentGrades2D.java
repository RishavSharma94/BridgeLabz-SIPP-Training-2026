import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        double[][] marks = new double[n][3]; // physics, chemistry, math
        double[] percent = new double[n];
        String[] grade = new String[n];
        
        System.out.println("Enter marks for each student:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i+1) + " physics: ");
            marks[i][0] = sc.nextDouble();
            System.out.print("Student " + (i+1) + " chemistry: ");
            marks[i][1] = sc.nextDouble();
            System.out.print("Student " + (i+1) + " math: ");
            marks[i][2] = sc.nextDouble();
            
            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            
            if (percent[i] >= 80) {
                grade[i] = "A";
            } else if (percent[i] >= 70) {
                grade[i] = "B";
            } else if (percent[i] >= 60) {
                grade[i] = "C";
            } else if (percent[i] >= 50) {
                grade[i] = "D";
            } else if (percent[i] >= 40) {
                grade[i] = "E";
            } else {
                grade[i] = "R";
            }
        }
        
        System.out.println("\nStudent\tPhy\tChem\tMath\t%\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.1f\t%.1f\t%.1f\t%.2f\t%s\n", i+1, marks[i][0], marks[i][1], marks[i][2], percent[i], grade[i]);
        }
    }
}
