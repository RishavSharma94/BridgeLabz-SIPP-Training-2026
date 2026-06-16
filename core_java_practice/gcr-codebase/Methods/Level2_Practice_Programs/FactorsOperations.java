import java.util.*;

public class FactorsOperations {

    // find factors
    public static int[] getFactors(int n) {
        int count = 0;

        // count factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;

        // store factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }

    public static int product(int[] arr) {
        int p = 1;
        for (int x : arr) p *= x;
        return p;
    }

    public static int sumOfSquares(int[] arr) {
        int s = 0;
        for (int x : arr) s += Math.pow(x, 2);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int[] factors = getFactors(n);

        System.out.println("Factors:");
        for (int x : factors) {
            System.out.print(x + " ");
        }

        System.out.println("\nSum = " + sum(factors));
        System.out.println("Product = " + product(factors));
        System.out.println("Sum of Squares = " + sumOfSquares(factors));
    }
}