import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        double[] phy = new double[n];
        double[] chem = new double[n];
        double[] math = new double[n];
        double[] percent = new double[n];
        String[] grade = new String[n];
        
        System.out.println("Enter marks for each student (physics, chemistry, math):");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i+1) + " physics: ");
            phy[i] = sc.nextDouble();
            System.out.print("Student " + (i+1) + " chemistry: ");
            chem[i] = sc.nextDouble();
            System.out.print("Student " + (i+1) + " math: ");
            math[i] = sc.nextDouble();
            
            percent[i] = (phy[i] + chem[i] + math[i]) / 3.0;
            
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
            System.out.printf("%d\t%.1f\t%.1f\t%.1f\t%.2f\t%s\n", i+1, phy[i], chem[i], math[i], percent[i], grade[i]);
        }
    }
}
