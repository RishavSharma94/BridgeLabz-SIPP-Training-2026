import java.util.Scanner;

public class StoreUpToTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        int idx = 0;
        
        System.out.println("Enter positive numbers (enter 0 or negative to stop):");
        while (true) {
            System.out.print("Enter number: ");
            double v = sc.nextDouble();
            
            if (v <= 0) break;
            if (idx == 10) break;
            
            arr[idx] = v;
            idx++;
        }
        
        System.out.println("\nNumbers entered:");
        double sum = 0;
        for (int i = 0; i < idx; i++) {
            System.out.println((i+1) + ": " + arr[i]);
            sum += arr[i];
        }
        
        System.out.println("Total sum: " + sum);
    }
}
