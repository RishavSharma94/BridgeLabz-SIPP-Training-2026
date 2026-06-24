import java.util.Scanner;

public class SplitWithoutBuiltin {

    static String[] splitWords(String str) {
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                count++;
        }

        String[] words = new String[count];
        int index = 0;
        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                temp += str.charAt(i);
            else {
                words[index++] = temp;
                temp = "";
            }
        }
        words[index] = temp;
        return words;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] manual = splitWords(str);
        String[] builtin = str.split(" ");

        System.out.println("Manual:");
        for (String w : manual)
            System.out.println(w);

        System.out.println("Same length? " + (manual.length == builtin.length));
    }
}