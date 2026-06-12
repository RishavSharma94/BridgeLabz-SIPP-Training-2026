import java.util.Scanner;

public class DigitsLargestSecondDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = Math.abs(sc.nextLong());
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int idx = 0;
        
        while (num != 0) {
            if (idx == maxDigit) {
                maxDigit = maxDigit + 10;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }
            digits[idx] = (int)(num % 10);
            idx++;
            num = num / 10;
        }
        
        int largest = -1, second = -1;
        for (int i = 0; i < idx; i++) {
            if (digits[i] > largest) {
                second = largest;
                largest = digits[i];
            } else if (digits[i] > second && digits[i] != largest) {
                second = digits[i];
            }
        }
        
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + second);
    }
}
