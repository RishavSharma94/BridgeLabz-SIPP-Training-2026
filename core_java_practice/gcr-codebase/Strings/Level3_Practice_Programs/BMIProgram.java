import java.util.Scanner;

public class BMIProgram {

    public static String getStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i+1));
            System.out.print("Weight: ");
            data[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        System.out.println("\nHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];
            double height = data[i][1] / 100;

            double bmi = weight / (height * height);
            bmi = Math.round(bmi * 100.0) / 100.0;

            System.out.println(data[i][1] + "\t" + weight + "\t" + bmi + "\t" + getStatus(bmi));
        }
    }
}