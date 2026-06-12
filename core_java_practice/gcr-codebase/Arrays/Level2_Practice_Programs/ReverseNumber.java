import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = Math.abs(sc.nextLong());
        
        int[] digits = new int[20];
        int idx = 0;
        
        while (num != 0) {
            digits[idx] = (int)(num % 10);
            num = num / 10;
            idx++;
            
            if (idx == digits.length) {
                int[] temp = new int[digits.length * 2];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }
        }
        
        System.out.print("Reversed number: ");
        for (int i = 0; i < idx; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
