import java.util.*;

public class TestUserSolution {
    // User's solution
    public static int solve(int[][] matrix, int n, int[] array, int m) {
        // matrix represents connections, n is siteCount, array is siteGuardians, m is festivalSite
        int siteCount = n;
        int[] siteGuardians = array;
        int festivalSite = m;

        // Build adjacency list for the tree
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < siteCount; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] connection : matrix) {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected graph
        }

        // Perform preorder traversal to get the sequence
        boolean[] visited = new boolean[siteCount];
        List<Integer> sequence = new ArrayList<>();
        preorder(0, adj, visited, sequence);
        
        System.out.println("Preorder sequence: " + sequence);

        // The chosen site is the (festivalSite)th index in the sequence (0-based)
        int chosenSite = sequence.get(festivalSite);

        // Return the number of guardians at the chosen site
        return siteGuardians[chosenSite];
    }

    private static void preorder(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> sequence) {
        visited[node] = true;
        sequence.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                preorder(neighbor, adj, visited, sequence);
            }
        }
    }

    // For testing
    public static void main(String[] args) {
        // Example input: n=7, siteGuardians=[10, 20, 15, 25, 30, 18, 22], 
        // matrix=[[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6]], m=3
        int[][] matrix = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] siteGuardians = {10, 20, 15, 25, 30, 18, 22};
        int result = solve(matrix, 7, siteGuardians, 3);
        System.out.println("Result: " + result); // Should print 30
        
        System.out.println("Expected sequence should be: [3, 1, 4, 0, 5, 2, 6]");
        System.out.println("Expected M=3 means 3rd element (1-indexed) = index 2 = site 4 = 30 guardians");
    }
}
