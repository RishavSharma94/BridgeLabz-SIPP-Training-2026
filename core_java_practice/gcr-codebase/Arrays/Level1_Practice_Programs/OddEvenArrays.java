import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number N: ");
        int n = sc.nextInt();
        
        int capacity = n / 2 + 1;
        int[] evens = new int[capacity];
        int[] odds = new int[capacity];
        int eIdx = 0, oIdx = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                evens[eIdx] = i;
                eIdx++;
            } else {
                odds[oIdx] = i;
                oIdx++;
            }
        }
        
        System.out.println("\nEven numbers: ");
        for (int i = 0; i < eIdx; i++) {
            System.out.print(evens[i] + " ");
        }
        
        System.out.println("\n\nOdd numbers: ");
        for (int i = 0; i < oIdx; i++) {
            System.out.print(odds[i] + " ");
        }
        System.out.println();
    }
}
