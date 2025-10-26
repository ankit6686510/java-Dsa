class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1: nums = [1,2,3], k = 3
        int[] nums1 = {1, 2, 3};
        System.out.println("Example 1: " + solution.numGoodSubarrays(nums1, 3)); // Expected: 3
        
        // Example 2: nums = [2,2,2,2,2,2], k = 6
        int[] nums2 = {2, 2, 2, 2, 2, 2};
        System.out.println("Example 2: " + solution.numGoodSubarrays(nums2, 6)); // Expected: 2
    }
}
