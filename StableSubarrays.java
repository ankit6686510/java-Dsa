class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long count = 0;
        
        // Calculate prefix sums
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + capacity[i];
        }
        
        // For stable subarray [l, r]:
        // capacity[l] == capacity[r] = V
        // sum(capacity[l+1...r-1]) = V
        // Therefore: sum(capacity[l...r]) = V + V + V = 3V
        // prefix[r+1] - prefix[l] = 3V
        // So: prefix[l] = prefix[r+1] - 3V
        
        // Map: value -> (prefix_sum -> count)
        java.util.Map<Integer, java.util.Map<Long, Integer>> map = new java.util.HashMap<>();
        
        for (int r = 0; r < n; r++) {
            // For each r, add position r-2 to the map first (if valid)
            // This ensures all positions up to r-2 are available for matching
            if (r >= 2) {
                int valueL = capacity[r - 2];
                long prefixL = prefix[r - 2];
                
                map.putIfAbsent(valueL, new java.util.HashMap<>());
                map.get(valueL).put(prefixL, map.get(valueL).getOrDefault(prefixL, 0) + 1);
            }
            
            // Now check if there are valid l positions for current r
            // l must be at most r-2 to ensure subarray has length >= 3
            if (r >= 2) { // Need at least 3 elements
                int valueR = capacity[r];
                long targetPrefix = prefix[r + 1] - 3L * valueR;
                
                if (map.containsKey(valueR) && map.get(valueR).containsKey(targetPrefix)) {
                    count += map.get(valueR).get(targetPrefix);
                }
            }
        }
        
        return count;
    }
    
    // Test method
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] capacity1 = {9, 3, 3, 3, 9};
        System.out.println("Example 1: " + solution.countStableSubarrays(capacity1)); // Expected: 2
        
        // Example 2
        int[] capacity2 = {1, 2, 3, 4, 5};
        System.out.println("Example 2: " + solution.countStableSubarrays(capacity2)); // Expected: 0
        
        // Example 3
        int[] capacity3 = {-4, 4, 0, 0, -8, -4};
        System.out.println("Example 3: " + solution.countStableSubarrays(capacity3)); // Expected: 1
    }
}
