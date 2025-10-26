import java.util.*;

public class MakeItZigzag {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            System.out.println(solve(a, n));
        }
        
        sc.close();
    }
    
    public static long solve(int[] a, int n) {
        if (n == 1) {
            return 0;
        }
        
        // Try both patterns:
        // Pattern 1: b1 < b2 > b3 < b4 > ... (odd positions are valleys)
        // Pattern 2: b1 > b2 < b3 > b4 < ... (even positions are valleys)
        
        long cost1 = calculateMinCost(a, n, true);  // odd positions are valleys
        long cost2 = calculateMinCost(a, n, false); // even positions are valleys
        
        return Math.min(cost1, cost2);
    }
    
    private static long calculateMinCost(int[] original, int n, boolean oddPositionsAreValleys) {
        int[] a = original.clone();
        long operations = 0;
        
        // First, handle all peaks using operation 1 (free)
        for (int i = 0; i < n; i++) {
            boolean isValley = oddPositionsAreValleys ? (i % 2 == 1) : (i % 2 == 0);
            
            if (!isValley) { // This is a peak
                // Set to prefix maximum using operation 1 (free)
                int prefixMax = a[0];
                for (int j = 1; j <= i; j++) {
                    prefixMax = Math.max(prefixMax, a[j]);
                }
                a[i] = prefixMax;
            }
        }
        
        // Now handle valleys using operation 2 (costs operations)
        for (int i = 0; i < n; i++) {
            boolean isValley = oddPositionsAreValleys ? (i % 2 == 1) : (i % 2 == 0);
            
            if (isValley) {
                // This should be strictly smaller than both neighbors
                int minNeighbor = Integer.MAX_VALUE;
                
                if (i > 0) {
                    minNeighbor = Math.min(minNeighbor, a[i-1]);
                }
                if (i < n-1) {
                    minNeighbor = Math.min(minNeighbor, a[i+1]);
                }
                
                if (minNeighbor != Integer.MAX_VALUE) {
                    int target = minNeighbor - 1;
                    if (target < 1) target = 1; // Cannot go below 1
                    
                    if (a[i] > target) {
                        operations += a[i] - target;
                        a[i] = target;
                    }
                }
            }
        }
        
        return operations;
    }
}
