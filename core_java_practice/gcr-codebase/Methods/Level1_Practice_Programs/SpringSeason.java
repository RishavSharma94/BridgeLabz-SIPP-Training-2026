public class SpringSeason {

    public static boolean isSpring(int m, int d) {
        return (m == 3 && d >= 20) || (m > 3 && m < 6) || (m == 6 && d <= 20);
    }

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);

        if (isSpring(m, d))
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }
}