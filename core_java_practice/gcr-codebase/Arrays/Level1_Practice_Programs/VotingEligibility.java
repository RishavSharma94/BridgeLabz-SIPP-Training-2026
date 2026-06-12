import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Age " + (i+1) + ": ");
            ages[i] = sc.nextInt();
        }
        
        System.out.println("\nVoting Eligibility:");
        for (int age : ages) {
            if (age >= 18) {
                System.out.println("Age " + age + " - Can vote");
            } else {
                System.out.println("Age " + age + " - Cannot vote");
            }
        }
    }
}
