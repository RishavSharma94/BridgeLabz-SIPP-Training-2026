import java.util.Scanner;

public class BMIList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        
        System.out.println("Enter weight and height for each person:");
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i+1) + " weight (kg): ");
            weight[i] = sc.nextDouble();
            System.out.print("Person " + (i+1) + " height (m): ");
            height[i] = sc.nextDouble();
            
            bmi[i] = weight[i] / (height[i] * height[i]);
            
            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        
        System.out.println("\nPerson\tWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.1f\t%.1f\t%.2f\t%s\n", i+1, weight[i], height[i], bmi[i], status[i]);
        }
    }
}
