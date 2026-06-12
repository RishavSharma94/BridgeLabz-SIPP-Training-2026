import java.util.Scanner;

public class FactorsDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int maxSize = 10;
        int[] factors = new int[maxSize];
        int idx = 0;
        
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (idx == maxSize) {
                    maxSize = maxSize * 2;
                    int[] temp = new int[maxSize];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[idx] = i;
                idx++;
            }
        }
        
        System.out.println("\nFactors of " + num + ":");
        for (int i = 0; i < idx; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
    }
}
