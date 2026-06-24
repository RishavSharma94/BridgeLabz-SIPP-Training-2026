class InsufficientBalanceException extends Exception {
    private double balance;
    private double requestedAmount;

    public InsufficientBalanceException(double balance, double requestedAmount) {
        super("Insufficient balance! Available: " + balance + ", Requested: " + requestedAmount);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }
}

class ATM {
    double balance = 5000;

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {

        ATM atm = new ATM();

        try {
            atm.withdraw(8000); // test case
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}