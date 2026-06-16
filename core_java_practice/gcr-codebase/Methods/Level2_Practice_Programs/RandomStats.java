import java.util.*;

public class RandomStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000);
        }
        return arr;
    }

    public static double[] findStats(int[] arr) {
        int min = arr[0], max = arr[0], sum = 0;

        for (int x : arr) {
            sum += x;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        double avg = (double) sum / arr.length;
        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);

        System.out.println("Numbers: " + Arrays.toString(arr));

        double[] res = findStats(arr);

        System.out.println("Average: " + res[0]);
        System.out.println("Min: " + res[1]);
        System.out.println("Max: " + res[2]);
    }
}