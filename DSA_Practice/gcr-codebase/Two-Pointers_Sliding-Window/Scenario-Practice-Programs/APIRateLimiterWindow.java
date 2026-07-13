import java.util.HashMap;

public class APIRateLimiterWindow {

    public static void main(String[] args) {

        int[] keyIds = {1, 2, 1, 3, 4, 2, 3, 2, 1};

        int n = 2;

        System.out.println("Longest Subarray Length: "
                + longestSubarrayWithAtMostNDistinct(keyIds, n));
    }

    static int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {

        HashMap<Integer, Integer> frequency = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < keyIds.length; end++) {

            frequency.put(keyIds[end],
                    frequency.getOrDefault(keyIds[end], 0) + 1);

            while (frequency.size() > n) {

                int leftKey = keyIds[start];

                frequency.put(leftKey, frequency.get(leftKey) - 1);

                if (frequency.get(leftKey) == 0) {
                    frequency.remove(leftKey);
                }

                start++;
            }

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
            }
        }

        return maxLength;
    }
}