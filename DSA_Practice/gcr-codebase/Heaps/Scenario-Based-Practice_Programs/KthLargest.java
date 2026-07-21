import java.util.*;

public class KthLargest {

    static int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {

            if (pq.size() < k)
                pq.offer(num);

            else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        int[] arr = {10, 50, 20, 80, 40, 90, 70};

        System.out.println(findKthLargest(arr, 3));
    }
}