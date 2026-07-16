import java.util.HashMap;

public class FraudPairDetection {

    static int[] findFraudPair(int[] amounts, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {

            int complement = target - amounts[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(amounts[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] amounts = {15, 7, 11, 2};

        int[] ans = findFraudPair(amounts, 9);

        System.out.println("Indices : " + ans[0] + " " + ans[1]);
    }
}