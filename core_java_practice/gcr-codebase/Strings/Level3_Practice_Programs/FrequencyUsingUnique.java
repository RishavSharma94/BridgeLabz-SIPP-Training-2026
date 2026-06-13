import java.util.Scanner;

public class FrequencyUsingUnique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char[] unique = new char[str.length()];
        int index = 0;

        // find unique chars
        for (int i = 0; i < str.length(); i++) {
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[index++] = str.charAt(i);
            }
        }

        // frequency
        for (int i = 0; i < index; i++) {
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (unique[i] == str.charAt(j)) {
                    count++;
                }
            }

            System.out.println(unique[i] + " -> " + count);
        }
    }
}