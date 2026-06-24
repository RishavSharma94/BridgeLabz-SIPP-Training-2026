import java.util.*;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class ScenarioBasedQ_HospitalBillingSystem {

    public static void processBill(int totalItems, int[] patients, int index, String amountStr)
            throws InsufficientFundsException {

        try {
            int costPerItem = 1000 / totalItems;
            System.out.println("Cost per item: " + costPerItem);

            System.out.println("Patient ID: " + patients[index]);

            int amount = Integer.parseInt(amountStr);

            if (amount < 500) {
                throw new InsufficientFundsException("Payment failed: insufficient funds");
            }

            System.out.println("Payment successful!");

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero (no items in bill)");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input format for amount");
        }
    }

    public static void main(String[] args) {

        int[] patients = {101, 102, 103};

        try {
            processBill(0, patients, 5, "abc");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("System running safely without crash");
    }
}
