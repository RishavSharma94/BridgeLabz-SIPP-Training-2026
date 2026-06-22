import java.util.*;

class BankAccount {

    private int accountNumber;
    private String holder;
    private double balance;

    static int totalAccounts = 0;

    public BankAccount(int accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(holder + " deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(holder + " -> Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println(holder + " withdrew: " + amount);
        }
    }

    public void getStatement() {
        System.out.println("Account: " + accountNumber +
                " | Holder: " + holder +
                " | Balance: " + balance);
    }
}

public class ScenarioBasedQ_BankAccountSystem {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount(101, "Rishav", 5000);
        BankAccount acc2 = new BankAccount(102, "Aman", 7000);
        BankAccount acc3 = new BankAccount(103, "Priya", 9000);

        // 5 transactions for each account

        acc1.deposit(1000);
        acc1.withdraw(2000);
        acc1.deposit(500);
        acc1.withdraw(7000);
        acc1.deposit(300);

        acc2.deposit(2000);
        acc2.withdraw(1000);
        acc2.deposit(1500);
        acc2.withdraw(8000);
        acc2.deposit(400);

        acc3.deposit(3000);
        acc3.withdraw(2000);
        acc3.deposit(1000);
        acc3.withdraw(500);
        acc3.deposit(600);

        System.out.println("\n--- Final Statements ---");

        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        System.out.println("\nTotal Accounts Created: " + BankAccount.totalAccounts);
    }
}