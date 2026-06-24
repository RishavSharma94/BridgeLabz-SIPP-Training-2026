import java.util.Random;

public class VotingArray {

    public static void main(String[] args) {
        int[] ages = new int[10];
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            ages[i] = r.nextInt(50);
        }

        System.out.println("Age\tCan Vote");
        for (int age : ages) {
            boolean canVote = age >= 18;
            System.out.println(age + "\t" + canVote);
        }
    }
}