import java.util.*;

public class ScenarioBasedHeapQuestions {

    static class MaxHeap {
        int[] heap;
        int size;

        MaxHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        void insert(int value) {
            heap[size] = value;
            int current = size;

            while (current > 0 && heap[(current - 1) / 2] < heap[current]) {
                int temp = heap[current];
                heap[current] = heap[(current - 1) / 2];
                heap[(current - 1) / 2] = temp;
                current = (current - 1) / 2;
            }
            size++;
        }

        void printHeap() {
            System.out.print("Max Heap: ");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    }

    static void topKStocks(int[] stocks, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stock : stocks) {

            pq.offer(stock);

            if (pq.size() > k)
                pq.poll();
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty())
            ans.add(pq.poll());

        Collections.reverse(ans);

        System.out.println("Top " + k + " Performing Stocks:");
        for (int x : ans)
            System.out.print(x + " ");
        System.out.println();
    }

    static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void heapSort(int[] arr) {

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(10);

        int[] marketCap = {40, 10, 30, 50, 60};

        for (int x : marketCap)
            heap.insert(x);

        heap.printHeap();

        int[] stocks = {40, 90, 70, 20, 100, 60, 80};
        topKStocks(stocks, 3);

        int[] arr = {40, 10, 60, 20, 50};

        heapSort(arr);

        System.out.print("Heap Sort: ");
        for (int x : arr)
            System.out.print(x + " ");
    }
}