import java.util.*;

public class BFSShortestPath {

    static List<Integer> fewestFlights(Map<Integer, List<Integer>> graph, int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(src);
        visited.add(src);
        parent.put(src, null);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == dest)
                break;

            for (int next : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, node);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(dest))
            return new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        Integer cur = dest;
        while (cur != null) {
            path.addFirst(cur);
            cur = parent.get(cur);
        }

        return path;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4));
        graph.put(3, Arrays.asList(1, 5));
        graph.put(4, Arrays.asList(2, 6));
        graph.put(5, Arrays.asList(3, 6));
        graph.put(6, Arrays.asList(4, 5));

        System.out.println(fewestFlights(graph, 1, 6));
    }
}