import java.util.*;

public class NumberChecker1 {

    public static int countDigits(int n) {
        return String.valueOf(n).length();
    }

    public static int[] getDigits(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        return arr;
    }

    public static boolean isDuck(int n) {
        return String.valueOf(n).contains("0");
    }

    public static boolean isArmstrong(int n) {
        int[] d = getDigits(n);
        int power = d.length;
        int sum = 0;

        for (int x : d) sum += Math.pow(x, power);
        return sum == n;
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println("Digits: " + Arrays.toString(getDigits(n)));
        System.out.println("Duck: " + isDuck(n));
        System.out.println("Armstrong: " + isArmstrong(n));
    }
}