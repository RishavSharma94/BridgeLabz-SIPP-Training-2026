public class RaviProfile {
    public static void main(String[] args) {

        // Storing details
        String name = "Ravi";
        int age = 22;
        String rank = "Beginner";
        double salary = 50000;
        float membershipFee = 1500.50f;

        // Bonus calculation (12%)
        double bonus = salary * 0.12;

        // Casting bonus to int
        int bonusInt = (int) bonus;

        // Printing formatted output
        System.out.println("----- Welcome Card -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Rank: " + rank);
        System.out.println("Salary: INR " + salary);
        System.out.println("Membership Fee: INR " + membershipFee);
        System.out.println("Annual Bonus (12%): INR " + bonusInt);
    }
}