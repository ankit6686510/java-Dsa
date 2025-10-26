public class TestCorrect {
    public static void main(String[] args) {
        // Test case from the problem
        int[] test1 = {1, 4, 2, 5, 3};
        int[] test2 = {3, 3, 2, 1};
        
        System.out.println("Test 1: " + MakeItZigzagCorrect.solve(test1, test1.length)); // Expected: 0
        System.out.println("Test 2: " + MakeItZigzagCorrect.solve(test2, test2.length)); // Expected: 1
        
        // Debug test2
        System.out.println("\nDebugging test2:");
        debugTest2();
    }
    
    static void debugTest2() {
        int[] a = {3, 3, 2, 1};
        int n = a.length;
        
        System.out.println("Original: " + java.util.Arrays.toString(a));
        
        // Pattern 1: even indices are valleys (0, 2 are valleys, 1, 3 are peaks)
        int[] arr1 = a.clone();
        long ops1 = 0;
        
        // Process peaks first (indices 1, 3)
        for (int i = 1; i < n; i += 2) {
            int prefixMax = arr1[0];
            for (int j = 1; j <= i; j++) {
                prefixMax = Math.max(prefixMax, arr1[j]);
            }
            arr1[i] = prefixMax;
        }
        System.out.println("After setting peaks: " + java.util.Arrays.toString(arr1));
        
        // Process valleys (indices 0, 2)
        for (int i = 0; i < n; i += 2) {
            int minNeighbor = Integer.MAX_VALUE;
            if (i > 0) minNeighbor = Math.min(minNeighbor, arr1[i-1]);
            if (i < n-1) minNeighbor = Math.min(minNeighbor, arr1[i+1]);
            
            if (minNeighbor != Integer.MAX_VALUE) {
                int maxAllowed = minNeighbor - 1;
                if (maxAllowed < 1) maxAllowed = 1;
                
                if (arr1[i] > maxAllowed) {
                    ops1 += arr1[i] - maxAllowed;
                    arr1[i] = maxAllowed;
                }
            }
        }
        System.out.println("Pattern 1 final: " + java.util.Arrays.toString(arr1) + ", ops: " + ops1);
        
        // Pattern 2: odd indices are valleys (1, 3 are valleys, 0, 2 are peaks)
        int[] arr2 = a.clone();
        long ops2 = 0;
        
        // Process peaks first (indices 0, 2)
        for (int i = 0; i < n; i += 2) {
            int prefixMax = arr2[0];
            for (int j = 1; j <= i; j++) {
                prefixMax = Math.max(prefixMax, arr2[j]);
            }
            arr2[i] = prefixMax;
        }
        System.out.println("After setting peaks: " + java.util.Arrays.toString(arr2));
        
        // Process valleys (indices 1, 3)
        for (int i = 1; i < n; i += 2) {
            int minNeighbor = Integer.MAX_VALUE;
            if (i > 0) minNeighbor = Math.min(minNeighbor, arr2[i-1]);
            if (i < n-1) minNeighbor = Math.min(minNeighbor, arr2[i+1]);
            
            if (minNeighbor != Integer.MAX_VALUE) {
                int maxAllowed = minNeighbor - 1;
                if (maxAllowed < 1) maxAllowed = 1;
                
                if (arr2[i] > maxAllowed) {
                    ops2 += arr2[i] - maxAllowed;
                    arr2[i] = maxAllowed;
                }
            }
        }
        System.out.println("Pattern 2 final: " + java.util.Arrays.toString(arr2) + ", ops: " + ops2);
        
        System.out.println("Min operations: " + Math.min(ops1, ops2));
    }
}
