class PalindromeChecker {

    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    void display() {
        if (isPalindrome()) {
            System.out.println(text + " is Palindrome");
        } else {
            System.out.println(text + " is Not Palindrome");
        }
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        PalindromeChecker p = new PalindromeChecker("madam");
        p.display();
    }
}