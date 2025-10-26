import java.util.*;

public class MakeItZigzagOptimized {
    
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
        // Pattern 1: valley-peak-valley... (odd indices are peaks)
        // Pattern 2: peak-valley-peak... (even indices are peaks)
        
        long cost1 = calculateCost(a, n, false); // Even indices are valleys
        long cost2 = calculateCost(a, n, true);  // Even indices are peaks
        
        return Math.min(cost1, cost2);
    }
    
    private static long calculateCost(int[] a, int n, boolean evenIndexesPeaks) {
        int[] arr = a.clone();
        long operations = 0;
        
        for (int i = 0; i < n; i++) {
            boolean isPeak = evenIndexesPeaks ? (i % 2 == 0) : (i % 2 == 1);
            
            if (isPeak) {
                // This should be a peak - use operation 1 to set to prefix maximum
                int prefixMax = arr[0];
                for (int j = 1; j <= i; j++) {
                    prefixMax = Math.max(prefixMax, arr[j]);
                }
                arr[i] = prefixMax;
            } else {
                // This should be a valley - can only decrease using operation 2
                // Need to be smaller than both neighbors
                int minNeighbor = Integer.MAX_VALUE;
                
                if (i > 0) {
                    minNeighbor = Math.min(minNeighbor, arr[i-1]);
                }
                if (i < n-1) {
                    minNeighbor = Math.min(minNeighbor, arr[i+1]);
                }
                
                if (minNeighbor != Integer.MAX_VALUE && arr[i] >= minNeighbor) {
                    int target = minNeighbor - 1;
                    if (target < 1) target = 1;
                    operations += arr[i] - target;
                    arr[i] = target;
                }
            }
        }
        
        return operations;
    }
}
