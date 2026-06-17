import java.util.Scanner;

public class UsernameValidator {

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        // Check space
        boolean hasSpace = username.contains(" ");

        // Count characters
        int length = username.length();

        // Convert uppercase
        String upper = username.toUpperCase();

        // Palindrome check (ignore case)
        boolean palindrome = isPalindrome(username.toLowerCase());

        System.out.println("\nContains Space: " + hasSpace);
        System.out.println("Total Characters: " + length);
        System.out.println("Uppercase: " + upper);
        System.out.println("Is Palindrome: " + palindrome);

        sc.close();
    }
}