import java.util.Scanner;

public class UniqueCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        char[] result = new char[str.length()];
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                result[index++] = str.charAt(i);
            }
        }

        System.out.print("Unique chars: ");
        for (int i = 0; i < index; i++) {
            System.out.print(result[i] + " ");
        }
    }
}