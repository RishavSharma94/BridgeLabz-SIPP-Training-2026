import java.util.Scanner;

public class PosNegCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        
        System.out.println("\nPositive/Negative/Zero & Even/Odd:");
        for (int x : arr) {
            if (x > 0) {
                if (x % 2 == 0) {
                    System.out.println(x + " is positive and even");
                } else {
                    System.out.println(x + " is positive and odd");
                }
            } else if (x < 0) {
                System.out.println(x + " is negative");
            } else {
                System.out.println(x + " is zero");
            }
        }
        
        System.out.println("\nCompare first and last:");
        int first = arr[0];
        int last = arr[4];
        if (first == last) {
            System.out.println("First and last are equal: " + first);
        } else if (first > last) {
            System.out.println("First (" + first + ") > Last (" + last + ")");
        } else {
            System.out.println("First (" + first + ") < Last (" + last + ")");
        }
    }
}
