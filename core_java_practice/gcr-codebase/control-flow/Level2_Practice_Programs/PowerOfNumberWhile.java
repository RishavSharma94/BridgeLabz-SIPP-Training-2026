import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a base number: ");
        int number = scanner.nextInt();
        System.out.print("Enter a power: ");
        int power = scanner.nextInt();

        if (power < 0) {
            System.out.println("Please enter a non-negative power.");
            return;
        }

        int result = 1;
        int counter = 0;
        while (counter < power) {
            result *= number;
            counter++;
        }

        System.out.println(number + "^" + power + " = " + result);
    }
}
