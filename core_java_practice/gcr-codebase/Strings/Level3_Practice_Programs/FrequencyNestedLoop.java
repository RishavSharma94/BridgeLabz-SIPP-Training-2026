import java.util.Scanner;

public class FrequencyNestedLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char[] arr = str.toCharArray();

        int[] freq = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            freq[i] = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++;
                    arr[j] = '0'; // mark duplicate
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0') {
                System.out.println(arr[i] + " -> " + freq[i]);
            }
        }
    }
}
