package com.accolite.assignment;
import java.util.util.*;
import java.lang.*;
import java.io.*;

// Function signature should not be modified, else code will not be evaluated
public class SpiritFestival {
    
    public static int solve(int[][] matrix, int n, int[] array, int m) {
        // Build adjacency list from connections
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add connections to adjacency list
        for (int i = 0; i < matrix.length; i++) {
            int u = matrix[i][0];
            int v = matrix[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Build tree and perform inorder traversal to get sequence
        List<Integer> sequence = new ArrayList<>();
        boolean[] visited = new boolean[n];
        buildTreeAndTraverse(0, adj, array, visited, sequence);
        
        // Get the Mth site (1-indexed) and return its guardian count
        int targetSite = sequence.get(m - 1); // Convert to 0-indexed
        return array[targetSite];
    }
    
    private static void buildTreeAndTraverse(int node, List<List<Integer>> adj, int[] guardians, boolean[] visited, List<Integer> sequence) {
        visited[node] = true;
        
        // Get children and sort them to ensure left-first preference
        List<Integer> children = new ArrayList<>();
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                children.add(neighbor);
            }
        }
        Collections.sort(children);
        
        // Inorder traversal: Left, Root, Right
        if (children.size() >= 1) {
            buildTreeAndTraverse(children.get(0), adj, guardians, visited, sequence);
        }
        
        sequence.add(node);
        
        if (children.size() >= 2) {
            buildTreeAndTraverse(children.get(1), adj, guardians, visited, sequence);
        }
    }
}
