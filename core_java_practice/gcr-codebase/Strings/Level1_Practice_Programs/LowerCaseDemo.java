import java.util.Scanner;

public class LowerCaseDemo {

    static String convert(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                result += (char)(ch + 32);
            else
                result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String manual = convert(str);
        String builtin = str.toLowerCase();

        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtin);
    }
}