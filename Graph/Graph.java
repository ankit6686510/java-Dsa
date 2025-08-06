import java.util.*;

public class Graph {
    class pair{
        int node;
        int weight;
        pair(int n , int w){
            node  = n;
            weight = w;
        }
        @Override
        public String toString(){
            return "(" + node + "," + weight +  ")" ;
        }
    }
    int[][] adjMatrix;
    List<List<Integer>> adjList;
    List<List<pair>> adjListWithWeight;

    // Constructor
    Graph(int nodes) {
        adjMatrix = new int[nodes][nodes]; // Initialize a nodes*nodes matrix with 0

        adjList = new ArrayList<>();
        adjListWithWeight = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    // Add unweighted edges
    public void addEdgeInMatrix(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (isDirected) {
                adjMatrix[u][v] = 1;
            } else {
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    // Add weighted edges
    public void addEdgeInMatrixWithWeights(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (isDirected) {
                adjMatrix[u][v] = w;
            } else {
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }

    // Add edges in list
    public void addEdgeInList(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // int w = edge[2];

            if (isDirected) {
                adjList.get(u).add(v);

            } else {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }
    // Add edges with weight in list
    public void addEdgeInListWithWeight(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (isDirected) {
                adjList.get(u).add(v);

            } else {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }

    // Print the adjacency matrix
    public void printMatrix() {
        for (int[] row : adjMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        // Test 1: Undirected Unweighted Graph
        int nodes = 4;
        int[][] unweightedEdges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2, 3 }
        };

        Graph g1 = new Graph(nodes);
        g1.addEdgeInMatrix(unweightedEdges, false);
        System.out.println("Adjacency Matrix for Undirected Unweighted Graph:");
        g1.printMatrix();

        System.out.println();

        // Test 2: Directed Weighted Graph
        int[][] weightedEdges = {
                { 0, 1, 5 },
                { 0, 2, 3 },
                { 1, 2, 2 },
                { 2, 3, 7 }
        };

        Graph g2 = new Graph(nodes);
        g2.addEdgeInMatrixWithWeights(weightedEdges, true);
        System.out.println("Adjacency Matrix for Directed Weighted Graph:");
        g2.printMatrix();

        System.out.println();
        System.out.println("Adjacency List for Undirected Unweighted Graph:");
        g1.addEdgeInList(unweightedEdges, false); // false = undirected
        g1.PrintList();

    }

    public void PrintList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> [ ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j));
                if (j != adjList.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

}
