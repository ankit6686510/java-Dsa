import java.util.*;

class Solution {
    public long numGoodSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Count all good subarrays using prefix sum modulo k approach
        // If two prefix sums have the same modulo k, the subarray between them is divisible by k
        Map<Long, Long> modCount = new HashMap<>();
        modCount.put(0L, 1L);
        
        long currentMod = 0;
        long totalGoodSubarrays = 0;
        
        for (int num : nums) {
            // Calculate running sum modulo k
            currentMod = (currentMod + num % k + k) % k;
            
            // Add count of previous occurrences of this modulo value
            totalGoodSubarrays += modCount.getOrDefault(currentMod, 0L);
            
            // Update frequency map
            modCount.put(currentMod, modCount.getOrDefault(currentMod, 0L) + 1L);
        }
        
        // Step 2: Handle groups of consecutive equal elements
        // These were counted multiple times, so we need to adjust
        long singleGroupSubarrays = 0;
        long distinctSingleGroups = 0;
        
        int i = 0;
        while (i < n) {
            int groupStart = i;
            long value = nums[i];
            
            // Find length of consecutive equal elements
            while (i < n && nums[i] == value) {
                i++;
            }
            int groupSize = i - groupStart;
            
            // Calculate contribution from this group
            long valueMod = value % k;
            long g = gcd(valueMod, k);
            long step = k / g;
            long distinctCount = groupSize / step;
            
            if (distinctCount > 0) {
                distinctSingleGroups += distinctCount;
                
                // Count all subarrays within this group
                long withinGroupCount = distinctCount * (groupSize + 1) - 
                                       step * distinctCount * (distinctCount + 1) / 2;
                singleGroupSubarrays += withinGroupCount;
            }
        }
        
        // Step 3: Calculate final answer
        // Multi-group good subarrays + distinct single-group subarrays
        long multiGroupGood = totalGoodSubarrays - singleGroupSubarrays;
        return multiGroupGood + distinctSingleGroups;
    }
    
    private long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
