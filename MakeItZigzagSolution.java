import java.util.*;

public class MakeItZigzagSolution {
    
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
        
        // Try both zigzag patterns:
        // Pattern 1: even indices are valleys (0,2,4... < 1,3,5...)
        // Pattern 2: odd indices are valleys (1,3,5... < 0,2,4...)
        
        long cost1 = calculateCostForPattern(a, n, true);  // even indices are valleys
        long cost2 = calculateCostForPattern(a, n, false); // odd indices are valleys
        
        return Math.min(cost1, cost2);
    }
    
    private static long calculateCostForPattern(int[] a, int n, boolean evenIndexesAreValleys) {
        int[] arr = a.clone();
        long operations = 0;
        
        // Process each position
        for (int i = 0; i < n; i++) {
            boolean isValley = evenIndexesAreValleys ? (i % 2 == 0) : (i % 2 == 1);
            
            if (isValley) {
                // This position should be a valley
                // We can only use operation 2 (decrease by 1)
                // It should be smaller than both neighbors
                
                int leftNeighbor = (i > 0) ? arr[i-1] : Integer.MAX_VALUE;
                int rightNeighbor = (i < n-1) ? arr[i+1] : Integer.MAX_VALUE;
                
                // Find the minimum value this position can be
                int maxAllowed = Math.min(leftNeighbor, rightNeighbor) - 1;
                
                if (maxAllowed < 1) maxAllowed = 1; // Cannot go below 1
                
                if (arr[i] > maxAllowed) {
                    operations += arr[i] - maxAllowed;
                    arr[i] = maxAllowed;
                }
                
            } else {
                // This position should be a peak
                // We can use operation 1 (set to prefix maximum) for free
                
                int prefixMax = arr[0];
                for (int j = 1; j <= i; j++) {
                    prefixMax = Math.max(prefixMax, arr[j]);
                }
                arr[i] = prefixMax;
            }
        }
        
        return operations;
    }
}
