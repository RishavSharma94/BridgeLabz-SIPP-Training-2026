import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] distribute(int choco, int kids) {
        return new int[]{choco / kids, choco % kids};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt(), k = sc.nextInt();

        int[] res = distribute(c, k);

        System.out.println("Each gets: " + res[0]);
        System.out.println("Remaining: " + res[1]);

        sc.close();
    }
}