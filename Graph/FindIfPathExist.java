import java.util.ArrayList;
import java.util.List;

public class FindIfPathExist {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(source, destination, visited, graph);
    }

    private boolean dfs(int current, int destination, boolean[] visited, List<List<Integer>> graph) {
        if (current == destination)
            return true;
        if (visited[current])
            return false;

        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            if (dfs(neighbor, destination, visited, graph))
                return true;
        }

        return false;
    }
}
