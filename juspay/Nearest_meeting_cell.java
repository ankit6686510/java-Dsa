import java.util.*;

public class Nearest_meeting_cell {

    // Function to find nearest meeting cell
    public static int nearestMeetingCell(int[] edges, int src, int desc) {
        int n = edges.length;

        // BFS from a given source
        Map<Integer, Integer> srcVisited = bfs(src, edges);
        Map<Integer, Integer> descVisited = bfs(desc, edges);

        // Find the nearest common cell
        int nearestCell = -1;
        int minDistance = Integer.MAX_VALUE;
        
        for (int cell : srcVisited.keySet()) {
            if (descVisited.containsKey(cell)) {
                // Check the sum of distances from both src and desc to this cell
                int totalDistance = srcVisited.get(cell) + descVisited.get(cell);
                if (totalDistance < minDistance) {
                    minDistance = totalDistance;
                    nearestCell = cell;
                }
            }
        }

        return nearestCell;
    }

    // BFS function to find all reachable nodes from a source
    public static Map<Integer, Integer> bfs(int start, int[] edges) {
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int nextNode = edges[node];
            if (nextNode != -1 && !visited.containsKey(nextNode)) {
                visited.put(nextNode, visited.get(node) + 1);
                queue.add(nextNode);
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of cells
            int[] edges = new int[n];
            
            // Input edges array
            for (int i = 0; i < n; i++) {
                edges[i] = sc.nextInt();
            }
            
            // Input src and desc
            int src = sc.nextInt();
            int desc = sc.nextInt();
            
            // Find nearest meeting cell
            System.out.println(nearestMeetingCell(edges, src, desc));
        }
        
        sc.close();
    }
}
