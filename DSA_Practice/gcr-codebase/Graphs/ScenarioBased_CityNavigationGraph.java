import java.util.*;

public class ScenarioBased_CityNavigationGraph.java {

    static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        void addDirectedEdge(int u, int v) {
            adj.get(u).add(v);
        }

        void bfsShortestPath(int src, int dest) {
            boolean[] visited = new boolean[V];
            int[] parent = new int[V];
            Arrays.fill(parent, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(src);
            visited[src] = true;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                if (node == dest)
                    break;

                for (int next : adj.get(node)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        parent[next] = node;
                        queue.offer(next);
                    }
                }
            }

            if (!visited[dest]) {
                System.out.println("No Path Found");
                return;
            }

            ArrayList<Integer> path = new ArrayList<>();
            int cur = dest;

            while (cur != -1) {
                path.add(cur);
                cur = parent[cur];
            }

            Collections.reverse(path);
            System.out.println("Shortest Path: " + path);
        }

        void dfsAllPaths(int src, int dest) {
            boolean[] visited = new boolean[V];
            ArrayList<Integer> path = new ArrayList<>();
            dfs(src, dest, visited, path);
        }

        void dfs(int node, int dest, boolean[] visited, ArrayList<Integer> path) {
            visited[node] = true;
            path.add(node);

            if (node == dest) {
                System.out.println(path);
            } else {
                for (int next : adj.get(node)) {
                    if (!visited[next]) {
                        dfs(next, dest, visited, path);
                    }
                }
            }

            path.remove(path.size() - 1);
            visited[node] = false;
        }

        void connectedComponents() {
            boolean[] visited = new boolean[V];
            int count = 0;

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    count++;
                    System.out.print("Component " + count + ": ");
                    dfsComponent(i, visited);
                    System.out.println();
                }
            }
        }

        void dfsComponent(int node, boolean[] visited) {
            visited[node] = true;
            System.out.print(node + " ");

            for (int next : adj.get(node)) {
                if (!visited[next]) {
                    dfsComponent(next, visited);
                }
            }
        }

        boolean hasCycleDirected() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (cycleDFS(i, visited, recStack))
                    return true;
            }

            return false;
        }

        boolean cycleDFS(int node, boolean[] visited, boolean[] recStack) {

            if (recStack[node])
                return true;

            if (visited[node])
                return false;

            visited[node] = true;
            recStack[node] = true;

            for (int next : adj.get(node)) {
                if (cycleDFS(next, visited, recStack))
                    return true;
            }

            recStack[node] = false;
            return false;
        }
    }

    public static void main(String[] args) {

        Graph city = new Graph(10);

        city.addEdge(0, 1);
        city.addEdge(0, 2);
        city.addEdge(1, 3);
        city.addEdge(2, 3);
        city.addEdge(3, 4);
        city.addEdge(4, 5);
        city.addEdge(5, 6);
        city.addEdge(7, 8);

        System.out.println("BFS Shortest Path:");
        city.bfsShortestPath(0, 6);

        System.out.println("\nDFS All Paths:");
        city.dfsAllPaths(0, 6);

        System.out.println("\nConnected Components:");
        city.connectedComponents();

        Graph course = new Graph(4);

        course.addDirectedEdge(0, 1);
        course.addDirectedEdge(1, 2);
        course.addDirectedEdge(2, 3);
        course.addDirectedEdge(3, 1);

        System.out.println("\nCycle in Directed Graph: " + course.hasCycleDirected());
    }
}