import java.util.*;

public class Connectivity {

    static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);

        for (int next : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(next)) {
                dfs(graph, next, visited);
            }
        }
    }

    static int connectedComponents(Map<Integer, List<Integer>> graph, int n) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(graph, i, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(0, 2));
        graph.put(2, Arrays.asList(1));

        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList(3));

        int components = connectedComponents(graph, 5);

        System.out.println("Connected Components = " + components);

        if (components == 1)
            System.out.println("Fully Connected");
        else
            System.out.println("Not Fully Connected");
    }
}