import java.util.HashMap;

public class SubarraySumEqualsK {

    static int subarraySumEqualsK(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : arr) {

            sum += num;

            count += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, -2, 2};

        System.out.println("Subarrays : " + subarraySumEqualsK(arr, 3));
    }
}