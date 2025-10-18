import java.util.*;

public class CorrectSolution {
    public static int solve(int[][] matrix, int n, int[] array, int m) {
        // Build adjacency list for the tree
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] connection : matrix) {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Perform INORDER traversal to get the correct sequence
        boolean[] visited = new boolean[n];
        List<Integer> sequence = new ArrayList<>();
        inorder(0, adj, visited, sequence);
        
        System.out.println("Correct inorder sequence: " + sequence);

        // The chosen site is the (m)th element (1-indexed)
        int chosenSite = sequence.get(m - 1); // Convert to 0-indexed

        return array[chosenSite];
    }

    private static void inorder(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> sequence) {
        visited[node] = true;
        
        // Get children and sort them for consistent left-right order
        List<Integer> children = new ArrayList<>();
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                children.add(neighbor);
            }
        }
        Collections.sort(children);
        
        // INORDER: Left, Root, Right
        if (children.size() >= 1) {
            inorder(children.get(0), adj, visited, sequence); // Left
        }
        
        sequence.add(node); // Root
        
        if (children.size() >= 2) {
            inorder(children.get(1), adj, visited, sequence); // Right
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] siteGuardians = {10, 20, 15, 25, 30, 18, 22};
        int result = solve(matrix, 7, siteGuardians, 3);
        System.out.println("Result: " + result);
    }
}
