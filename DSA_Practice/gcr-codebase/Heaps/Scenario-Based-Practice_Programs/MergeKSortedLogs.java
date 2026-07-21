import java.util.*;

public class MergeKSortedLogs {

    static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    static List<Integer> merge(int[][] arr) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {

            Node curr = pq.poll();
            ans.add(curr.value);

            if (curr.col + 1 < arr[curr.row].length) {
                pq.offer(new Node(arr[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] arr = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        System.out.println(merge(arr));
    }
}