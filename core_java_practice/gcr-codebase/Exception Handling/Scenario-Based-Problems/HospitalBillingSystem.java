import java.util.*;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

public class HospitalBillingSystem {

    public static void processBill(int totalItems, int[] patients, int index, String amountStr)
            throws InsufficientFundsException {

        try {
            // Division
            int costPerItem = 1000 / totalItems;
            System.out.println("Cost per item: " + costPerItem);

            // Array access
            System.out.println("Patient ID: " + patients[index]);

            // Number format
            int amount = Integer.parseInt(amountStr);

            // Payment check
            if (amount < 500) {
                throw new InsufficientFundsException("Payment failed: insufficient funds");
            }

            System.out.println("Payment successful!");

        } catch (ArithmeticException e) {
            System.out.println("Error: No items in bill (division by zero)");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid amount format");
        }
    }

    public static void main(String[] args) {
        int[] patients = {101, 102, 103};

        try {
            processBill(0, patients, 5, "abc"); // test cases
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}