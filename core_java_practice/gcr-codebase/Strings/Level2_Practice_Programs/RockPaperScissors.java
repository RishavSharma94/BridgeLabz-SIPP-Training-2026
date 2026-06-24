import java.util.*;

public class RockPaperScissors {

    static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[new Random().nextInt(3)];
    }

    static String winner(String user, String comp) {
        if (user.equals(comp)) return "Draw";

        if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper")))
            return "User";

        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter choice: ");
        String user = sc.next();

        String comp = getComputerChoice();

        System.out.println("Computer: " + comp);
        System.out.println("Winner: " + winner(user, comp));
    }
}