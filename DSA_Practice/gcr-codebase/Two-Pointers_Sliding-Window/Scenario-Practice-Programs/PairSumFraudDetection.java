public class PairSumFraudDetection {

    public static void main(String[] args) {

        int[] transactions = {5000, 8000, 12000, 15000, 20000, 30000};

        int target = 35000;

        int[] pair = findPairSum(transactions, target);

        if (pair[0] == -1)
            System.out.println("Pair Not Found");
        else
            System.out.println("Pair Found: " + pair[0] + " " + pair[1]);
    }

    static int[] findPairSum(int[] transactions, int target) {

        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {

            int sum = transactions[left] + transactions[right];

            if (sum == target)
                return new int[]{transactions[left], transactions[right]};

            if (sum < target)
                left++;
            else
                right--;
        }

        return new int[]{-1, -1};
    }
}