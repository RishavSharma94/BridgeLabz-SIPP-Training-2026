import java.util.Scanner;

public class OddEvenRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number >= 1) {
            for (int i = 1; i <= number; i++) {
                String type = (i % 2 == 0) ? "even" : "odd";
                System.out.println(i + " is an " + type + " number");
            }
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        scanner.close();
    }
}
