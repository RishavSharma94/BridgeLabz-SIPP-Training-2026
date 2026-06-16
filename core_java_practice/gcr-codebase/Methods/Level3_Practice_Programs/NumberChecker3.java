import java.util.*;

public class NumberChecker3 {

    public static int[] reverse(int[] arr) {
        int n = arr.length;
        int[] rev = new int[n];

        for (int i = 0; i < n; i++) {
            rev[i] = arr[n - 1 - i];
        }
        return rev;
    }

    public static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println("Palindrome: " + isPalindrome(n));
    }
}