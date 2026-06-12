import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year (>= 1582): ");
        int year = scanner.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later for the Gregorian calendar.");
            return;
        }

        System.out.println("-- Using multiple if-else statements --");
        if (year % 4 != 0) {
            System.out.println(year + " is not a Leap Year");
        } else if (year % 100 != 0) {
            System.out.println(year + " is a Leap Year");
        } else if (year % 400 == 0) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }

        System.out.println("-- Using a single if statement with logical operators --");
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
    }
}
