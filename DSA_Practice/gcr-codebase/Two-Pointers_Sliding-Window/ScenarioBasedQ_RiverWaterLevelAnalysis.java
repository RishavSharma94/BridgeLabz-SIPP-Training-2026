public class ScenarioBasedQ_RiverWaterLevelAnalysis {

    public static void main(String[] args) {

        // Water Levels
        int[] waterLevels = {4, 5, 6, 7, 5, 4, 8, 9, 6};

        int limit = 3;

        System.out.println("Longest Stable Period: "
                + longestStablePeriod(waterLevels, limit));

        // Pollution Index
        int[] pollution = {-2, -1, 0, 1, 2, -1, -4};

        System.out.println("\nTriplets with Sum Zero:");
        findTriplets(pollution);

        // Max Average Subarray
        int[] averageLevels = {2, 5, 3, 8, 9, 1, 7};

        int k = 3;

        System.out.println("\nMaximum Average: "
                + maxAverageSubarray(averageLevels, k));
    }

    // Longest Contiguous Period (Sliding Window)
    static int longestStablePeriod(int[] arr, int limit) {

        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int max = arr[i];

            for (int j = i; j < arr.length; j++) {

                if (arr[j] < min)
                    min = arr[j];

                if (arr[j] > max)
                    max = arr[j];

                if (max - min <= limit)
                    maxLength = Math.max(maxLength, j - i + 1);
                else
                    break;
            }
        }

        return maxLength;
    }

    // Triplets with Sum = 0
    static void findTriplets(int[] arr) {

        java.util.Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {

                    System.out.println(arr[i] + " "
                            + arr[left] + " "
                            + arr[right]);

                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1])
                        left++;

                    while (left < right && arr[right] == arr[right + 1])
                        right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    // Maximum Average Subarray of Length k
    static double maxAverageSubarray(int[] arr, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += arr[i];

        int maxSum = sum;

        for (int i = k; i < arr.length; i++) {

            sum += arr[i] - arr[i - k];

            if (sum > maxSum)
                maxSum = sum;
        }

        return (double) maxSum / k;
    }
}