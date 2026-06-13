import java.util.Scanner;

public class TrimManual {

    static String trim(String str) {
        int start = 0, end = str.length() - 1;

        while (str.charAt(start) == ' ') start++;
        while (str.charAt(end) == ' ') end--;

        return str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String manual = trim(str);
        String builtin = str.trim();

        System.out.println("Manual: [" + manual + "]");
        System.out.println("Built-in: [" + builtin + "]");
    }
}