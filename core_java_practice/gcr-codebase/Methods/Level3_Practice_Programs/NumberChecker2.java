import java.util.*;

public class NumberChecker2 {

    public static int sumDigits(int[] d) {
        int s = 0;
        for (int x : d) s += x;
        return s;
    }

    public static int sumSquare(int[] d) {
        int s = 0;
        for (int x : d) s += x * x;
        return s;
    }

    public static boolean isHarshad(int n) {
        int sum = sumDigits(String.valueOf(n).chars().map(c -> c - '0').toArray());
        return n % sum == 0;
    }

    public static void main(String[] args) {
        int n = 21;
        int[] d = String.valueOf(n).chars().map(c -> c - '0').toArray();

        System.out.println("Sum: " + sumDigits(d));
        System.out.println("Square Sum: " + sumSquare(d));
        System.out.println("Harshad: " + isHarshad(n));
    }
}
