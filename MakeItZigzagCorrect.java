import java.util.*;

public class MakeItZigzagCorrect {
    
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
        // Pattern 1: valleys at even indices (0, 2, 4, ...)
        // Pattern 2: valleys at odd indices (1, 3, 5, ...)
        
        long cost1 = calculateCost(a.clone(), n, true);  // even indices are valleys
        long cost2 = calculateCost(a.clone(), n, false); // odd indices are valleys
        
        return Math.min(cost1, cost2);
    }
    
    private static long calculateCost(int[] a, int n, boolean evenIndexesAreValleys) {
        long operations = 0;
        
        for (int i = 0; i < n; i++) {
            boolean isValley = evenIndexesAreValleys ? (i % 2 == 0) : (i % 2 == 1);
            
            if (isValley) {
                // This should be a valley - can only decrease using operation 2
                // It should be strictly smaller than both neighbors
                
                int minNeighbor = Integer.MAX_VALUE;
                
                // Check left neighbor
                if (i > 0) {
                    minNeighbor = Math.min(minNeighbor, a[i-1]);
                }
                
                // Check right neighbor
                if (i < n-1) {
                    minNeighbor = Math.min(minNeighbor, a[i+1]);
                }
                
                // If we have neighbors, we need to be strictly smaller
                if (minNeighbor != Integer.MAX_VALUE) {
                    int maxAllowed = minNeighbor - 1;
                    if (maxAllowed < 1) maxAllowed = 1; // Can't go below 1
                    
                    if (a[i] > maxAllowed) {
                        operations += a[i] - maxAllowed;
                        a[i] = maxAllowed;
                    }
                }
                
            } else {
                // This should be a peak - use operation 1 to set to prefix maximum
                // This costs 0 operations
                
                int prefixMax = a[0];
                for (int j = 1; j <= i; j++) {
                    prefixMax = Math.max(prefixMax, a[j]);
                }
                a[i] = prefixMax;
            }
        }
        
        return operations;
    }
}
