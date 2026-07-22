import java.util.*;

public class FeatureFlagCombinationTesting {

    public static void main(String[] args) {
        String[] flags = {"DarkMode", "Search", "Checkout"};
        List<List<String>> result = new ArrayList<>();
        generate(flags, 0, new ArrayList<>(), result);

        for (List<String> list : result)
            System.out.println(list);
    }

    static void generate(String[] flags, int index, List<String> current, List<List<String>> result) {
        if (index == flags.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(flags[index]);
        generate(flags, index + 1, current, result);

        current.remove(current.size() - 1);
        generate(flags, index + 1, current, result);
    }
}