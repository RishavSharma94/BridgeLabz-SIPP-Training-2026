import java.util.Scanner;

public class SecretMessageValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter secret code: ");
        String text = sc.nextLine();

        int vowels = 0, consonants = 0, digits = 0, special = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isDigit(ch)) {
                digits++;
            }
            else if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
            else {
                special++;
            }
        }

        // Strength check
        boolean isStrong = (digits >= 2 && special >= 1 && text.length() >= 8);

        System.out.println("\nVowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + special);

        if (isStrong) {
            System.out.println("Strength: Strong");
        } else {
            System.out.println("Strength: Weak");
        }

        sc.close();
    }
}