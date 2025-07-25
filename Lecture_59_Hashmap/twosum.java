package Lecture_59_Hashmap;

public class twosum {
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store number-index pairs
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed
            int complement = target - nums[i];

            // If complement exists in HashMap, we found a solution
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            // Add current number and its index to HashMap
            numMap.put(nums[i], i);
        }

        // No solution found
        return new int[] {};
    }
}
