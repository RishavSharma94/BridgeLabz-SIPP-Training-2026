import java.util.*;

public class SubsetsRecursion {

    public static void subsets(int[] arr, int index, List<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        subsets(arr, index + 1, list);

        list.remove(list.size() - 1);
        subsets(arr, index + 1, list);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        subsets(arr, 0, new ArrayList<>());
    }
}