import java.util.*;

public class VendingMachineChangeMaking {

    public static void main(String[] args) {
        int[] coins = {2, 3, 5};
        Arrays.sort(coins);
        List<List<Integer>> result = new ArrayList<>();

        change(coins, 7, 0, new ArrayList<>(), result);

        for (List<Integer> list : result)
            System.out.println(list);
    }

    static void change(int[] coins, int target, int start, List<Integer> path, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < coins.length; i++) {
            if (coins[i] > target)
                break;

            path.add(coins[i]);
            change(coins, target - coins[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }
}