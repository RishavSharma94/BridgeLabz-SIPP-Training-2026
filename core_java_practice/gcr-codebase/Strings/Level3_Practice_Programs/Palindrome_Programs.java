import java.util.Scanner;

public class Palindrome {

    // Method 1
    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length()-1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    // Method 2 (Recursion)
    public static boolean rec(String str, int i, int j) {
        if (i >= j) return true;
        if (str.charAt(i) != str.charAt(j)) return false;
        return rec(str, i+1, j-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println("Normal: " + isPalindrome(str));
        System.out.println("Recursion: " + rec(str,0,str.length()-1));
    }
}