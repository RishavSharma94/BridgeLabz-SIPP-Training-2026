import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer greater than 1: ");
        int number = scanner.nextInt();

        if (number <= 1) {
            System.out.println("Please enter a number greater than 1.");
            return;
        }

        int greatestFactor = 1;
        int counter = number - 1;
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }

        System.out.println("Greatest factor of " + number + " besides itself is " + greatestFactor);
    }
}
