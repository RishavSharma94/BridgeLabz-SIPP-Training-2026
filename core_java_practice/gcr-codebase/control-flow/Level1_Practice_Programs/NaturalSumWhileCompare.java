import java.util.Scanner;

public class NaturalSumWhileCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number >= 1) {
            long formulaSum = (long) number * (number + 1) / 2;
            long loopSum = 0;
            int i = 1;
            while (i <= number) {
                loopSum += i;
                i++;
            }
            System.out.println("Formula sum: " + formulaSum);
            System.out.println("While-loop sum: " + loopSum);
            System.out.println("Both results are equal: " + (formulaSum == loopSum));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        scanner.close();
    }
}
