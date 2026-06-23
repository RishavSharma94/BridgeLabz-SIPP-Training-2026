abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {

    private double interestRate;

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {

    private double monthlyBonusRate;

    public void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    public double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        SavingsAccount s = new SavingsAccount();
        s.setAccountNumber("ACC101");
        s.setHolderName("Rishav");
        s.setBalance(10000);
        s.setInterestRate(5);

        s.deposit(2000);
        s.withdraw(3000);

        s.displayAccountDetails();
        System.out.println("Interest: " + s.calculateInterest());

        System.out.println();

        CurrentAccount c = new CurrentAccount();
        c.setAccountNumber("ACC202");
        c.setHolderName("Rahul");
        c.setBalance(15000);
        c.setMonthlyBonusRate(2);

        c.deposit(1000);
        c.withdraw(5000);

        c.displayAccountDetails();
        System.out.println("Interest: " + c.calculateInterest());
    }
}