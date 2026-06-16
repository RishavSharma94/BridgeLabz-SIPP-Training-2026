import java.util.*;

public class LeapYearCheck {

    public static boolean isLeap(int year) {
        if (year < 1582) return false;

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (isLeap(year))
            System.out.println("Leap Year");
        else
            System.out.println("Not a Leap Year");
    }
}