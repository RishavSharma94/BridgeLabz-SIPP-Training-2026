import java.util.Scanner;

public class QuotientRemainder {

    public static int[] calc(int a, int b) {
        return new int[]{a / b, a % b};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();

        int[] res = calc(a, b);

        System.out.println("Quotient: " + res[0]);
        System.out.println("Remainder: " + res[1]);

        sc.close();
    }
}