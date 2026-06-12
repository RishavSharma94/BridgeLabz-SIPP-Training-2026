import java.util.Scanner;

public class MeanHeights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        
        System.out.println("Enter heights of 11 football players:");
        for (int i = 0; i < 11; i++) {
            System.out.print("Height " + (i+1) + " (in meters): ");
            heights[i] = sc.nextDouble();
        }
        
        double sum = 0;
        for (double h : heights) {
            sum = sum + h;
        }
        
        double mean = sum / 11;
        System.out.println("\nMean height of team: " + mean + " meters");
    }
}
