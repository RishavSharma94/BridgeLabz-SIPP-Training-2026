import java.util.Arrays;
import java.util.Scanner;

public class WordMatchSystem {

    // Method to check anagram
    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        char[] a = s1.toLowerCase().toCharArray();
        char[] b = s2.toLowerCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first word: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second word: ");
        String s2 = sc.nextLine();

        boolean result = isAnagram(s1, s2);

        System.out.println("\nUppercase Words:");
        System.out.println(s1.toUpperCase());
        System.out.println(s2.toUpperCase());

        System.out.println("Length of first word: " + s1.length());
        System.out.println("Length of second word: " + s2.length());

        if (result) {
            System.out.println("Both words are Anagrams ✅");
        } else {
            System.out.println("Not Anagrams ❌");
        }

        sc.close();
    }
}