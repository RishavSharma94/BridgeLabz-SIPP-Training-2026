import java.util.Scanner;

public class DigitFrequency {
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
        
        int[] freq = new int[10];
        for (int i = 0; i < idx; i++) {
            freq[digits[i]]++;
        }
        
        System.out.println("Digit Frequency:");
        for (int d = 0; d < 10; d++) {
            if (freq[d] > 0) {
                System.out.println("Digit " + d + " appears " + freq[d] + " times");
            }
        }
    }
}
