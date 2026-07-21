import java.util.*;

public class TopKLargest {

    static List<Integer> topK(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {

            if (pq.size() < k)
                pq.offer(num);

            else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        List<Integer> ans = new ArrayList<>(pq);
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {10, 50, 20, 80, 40, 90, 70};

        System.out.println(topK(arr, 3));
    }
}