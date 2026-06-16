import java.util.*;

public class BMIProgram {

    public static double calculateBMI(double weight, double heightCm) {
        double h = heightCm / 100;
        return weight / (h * h);
    }

    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            data[i][0] = sc.nextDouble(); // weight
            data[i][1] = sc.nextDouble(); // height

            data[i][2] = calculateBMI(data[i][0], data[i][1]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(data[i][0] + " " + data[i][1] + " BMI: " + data[i][2] + " " + getStatus(data[i][2]));
        }
    }
}