import java.util.*;

public class BuildMinHeap {

    static void heapify(int[] arr, int i, int n) {

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, smallest, n);
        }
    }

    static void buildHeap(int[] arr) {

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);
    }

    public static void main(String[] args) {

        int[] arr = {40, 10, 30, 50, 20};

        buildHeap(arr);

        System.out.println(Arrays.toString(arr));
    }
}