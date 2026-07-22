import java.util.*;

public class OnCallRotationScheduling {

    public static void main(String[] args) {
        String[] engineers = {"A", "B", "C"};
        boolean[] used = new boolean[engineers.length];

        permute(engineers, used, new ArrayList<>());
    }

    static void permute(String[] engineers, boolean[] used, List<String> list) {

        if (list.size() == engineers.length) {
            System.out.println(list);
            return;
        }

        for (int i = 0; i < engineers.length; i++) {

            if (used[i])
                continue;

            used[i] = true;
            list.add(engineers[i]);

            permute(engineers, used, list);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}