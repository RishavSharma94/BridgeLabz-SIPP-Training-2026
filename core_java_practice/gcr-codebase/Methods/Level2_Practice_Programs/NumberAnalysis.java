import java.util.*;

public class NumberAnalysis {

    public static boolean isPositive(int n) {
        return n >= 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) arr[i] = sc.nextInt();

        for (int x : arr) {
            if (isPositive(x)) {
                System.out.println(x + " is " + (isEven(x) ? "Even" : "Odd"));
            } else {
                System.out.println(x + " is Negative");
            }
        }

        int res = compare(arr[0], arr[4]);

        if (res == 0) System.out.println("Equal");
        else if (res == 1) System.out.println("First > Last");
        else System.out.println("First < Last");
    }
}