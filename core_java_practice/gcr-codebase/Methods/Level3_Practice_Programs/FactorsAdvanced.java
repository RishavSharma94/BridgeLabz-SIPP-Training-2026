import java.util.*;

public class FactorsAdvanced {

    public static int[] getFactors(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++)
            if (n % i == 0) count++;

        int[] arr = new int[count];
        int index = 0;

        for (int i = 1; i <= n; i++)
            if (n % i == 0) arr[index++] = i;

        return arr;
    }

    public static int maxFactor(int[] arr) {
        return arr[arr.length - 1];
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

    public static double cubeProduct(int[] arr) {
        double p = 1;
        for (int x : arr) p *= Math.pow(x, 3);
        return p;
    }

    public static void main(String[] args) {
        int n = 12;

        int[] f = getFactors(n);

        System.out.println(Arrays.toString(f));
        System.out.println("Max: " + maxFactor(f));
        System.out.println("Sum: " + sum(f));
        System.out.println("Product: " + product(f));
        System.out.println("Cube Product: " + cubeProduct(f));
    }
}