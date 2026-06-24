import java.util.Scanner;

public class StoryBasedQ_SpyMessageAnalyzer {

    // Reverse string
    public static String reverse(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

    // Palindrome check
    public static boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }

    // Count vowels & consonants
    public static void countVC(String str) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // Anagram check
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int i : freq) {
            if (i != 0) return false;
        }

        return true;
    }

    // First non-repeating character
    public static char firstNonRepeating(String str) {
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '#'; // no unique char
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🕵️ Spy Message Analyzer 🕵️");

        // Secret message
        System.out.print("Enter secret message: ");
        String msg = sc.nextLine();

        String reversed = reverse(msg);
        System.out.println("Reversed Message: " + reversed);

        if (isPalindrome(msg)) {
            System.out.println("The message is a PALINDROME");
        } else {
            System.out.println("The message is NOT a palindrome");
        }

        countVC(msg);

        // Anagram check
        System.out.print("\nEnter intercepted message 1: ");
        String s1 = sc.nextLine();

        System.out.print("Enter intercepted message 2: ");
        String s2 = sc.nextLine();

        if (isAnagram(s1, s2)) {
            System.out.println("Messages are ANAGRAMS");
        } else {
            System.out.println("Messages are NOT anagrams");
        }

        // First non-repeating
        char result = firstNonRepeating(msg);
        if (result != '#') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }

        sc.close();
    }
}