import java.util.Scanner;

public class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();

        System.out.print("Enter Amar's height in cm: ");
        int amarHeight = scanner.nextInt();
        System.out.print("Enter Akbar's height in cm: ");
        int akbarHeight = scanner.nextInt();
        System.out.print("Enter Anthony's height in cm: ");
        int anthonyHeight = scanner.nextInt();

        int youngestAge = amarAge;
        String youngestName = "Amar";
        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngestName = "Akbar";
        }
        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngestName = "Anthony";
        }

        int tallestHeight = amarHeight;
        String tallestName = "Amar";
        if (akbarHeight > tallestHeight) {
            tallestHeight = akbarHeight;
            tallestName = "Akbar";
        }
        if (anthonyHeight > tallestHeight) {
            tallestHeight = anthonyHeight;
            tallestName = "Anthony";
        }

        System.out.println("Youngest friend: " + youngestName + " (" + youngestAge + " years)");
        System.out.println("Tallest friend: " + tallestName + " (" + tallestHeight + " cm)");
    }
}
