import java.util.Scanner;

public class SubstringDemo {

    static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    static boolean compare(String a, String b) {
        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String sub1 = createSubstring(str, start, end);
        String sub2 = str.substring(start, end);

        System.out.println("Manual: " + sub1);
        System.out.println("Built-in: " + sub2);
        System.out.println("Same? " + compare(sub1, sub2));
    }
}