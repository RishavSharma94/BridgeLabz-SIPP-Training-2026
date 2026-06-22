class BankAccount {

    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class ATMSystem {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Rishav", 101, 5000);

        acc.deposit(1000);
        acc.withdraw(2000);
        acc.displayBalance();
    }
}