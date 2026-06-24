import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        int month;
        int day;

        if (args.length >= 2) {
            month = Integer.parseInt(args[0]);
            day = Integer.parseInt(args[1]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter month (1-12): ");
            month = scanner.nextInt();
            System.out.print("Enter day: ");
            day = scanner.nextInt();
            scanner.close();
        }

        boolean isSpring = (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
        System.out.println(isSpring ? "Its a Spring Season" : "Not a Spring Season");
    }
}
