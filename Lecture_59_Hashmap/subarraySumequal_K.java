package Lecture_59_Hashmap;

import java.util.*;

public class subarraySumequal_K {
    
    public int subarraySum(int[] nums, int k) {
        // Map to store prefix sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // very important: base case for subarray starting from index 0

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // If prefix sum 'sum - k' exists, that means there's a subarray ending here which sums to k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update the map with current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

