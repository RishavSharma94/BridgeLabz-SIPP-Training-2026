import java.util.Scanner;

public class BMIMultiDim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        
        double[][] personData = new double[n][3]; // weight, height, bmi
        String[] weightStatus = new String[n];
        
        System.out.println("Enter weight and height for each person:");
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i+1) + " weight (kg): ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Person " + (i+1) + " height (m): ");
            personData[i][1] = sc.nextDouble();
            
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            double bmi = personData[i][2];
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        System.out.println("\nPerson\tWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.1f\t%.1f\t%.2f\t%s\n", i+1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
