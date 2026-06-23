public class BankAccountSystem {

    static int totalAccounts = 0;

    String accountNumber;
    String holder;
    double balance;

    BankAccountSystem(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance for " + holder);
        } else {
            balance -= amount;
        }
    }

    void getStatement() {
        System.out.println(accountNumber + " " + holder + " " + balance);
    }

    public static void main(String[] args) {

        BankAccountSystem a1 = new BankAccountSystem("A101", "Rishav", 5000);
        BankAccountSystem a2 = new BankAccountSystem("A102", "Rahul", 7000);
        BankAccountSystem a3 = new BankAccountSystem("A103", "Aman", 9000);

        BankAccountSystem[] accounts = {a1, a2, a3};

        for (BankAccountSystem acc : accounts) {
            acc.deposit(1000);
            acc.withdraw(500);
            acc.deposit(200);
            acc.withdraw(300);
            acc.deposit(400);
            acc.getStatement();
        }

        System.out.println("Total Accounts: " + totalAccounts);
    }
}