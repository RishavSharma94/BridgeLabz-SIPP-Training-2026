public class ServerCPUSpikeDetection {

    public static void main(String[] args) {

        int[] cpuLoad = {10, 20, 30, 40, 50, 15, 25, 35};

        int k = 3;

        System.out.println("Maximum CPU Load: " + maxSubarrayOfSizeK(cpuLoad, k));
    }

    static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {

            windowSum += cpuLoad[end];

            if (end >= k - 1) {

                if (windowSum > maxSum)
                    maxSum = windowSum;

                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }
}