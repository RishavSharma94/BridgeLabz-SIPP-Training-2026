import java.util.Scanner;

public class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Height of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }
        
        int minAge = ages[0], minIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                minIdx = i;
            }
        }
        
        double maxHeight = heights[0], maxIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxIdx = i;
            }
        }
        
        System.out.println("\n" + names[minIdx] + " is youngest (age " + ages[minIdx] + ")");
        System.out.println(names[(int)maxIdx] + " is tallest (height " + heights[(int)maxIdx] + ")");
    }
}
