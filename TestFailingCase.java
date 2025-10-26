class TestFailingCase {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Failing test case
        int[] nums = {1, 1, 2, 3};
        int k = 1;
        long result = solution.numGoodSubarrays(nums, k);
        System.out.println("Input: nums = [1,1,2,3], k = 1");
        System.out.println("Output: " + result);
        System.out.println("Expected: 9");
        
        // Let's manually check what the distinct subarrays should be:
        System.out.println("\nExpected distinct subarrays (all divisible by 1):");
        System.out.println("1. [1]");
        System.out.println("2. [1,1]");
        System.out.println("3. [1,1,2]");
        System.out.println("4. [1,1,2,3]");
        System.out.println("5. [1,2]");
        System.out.println("6. [1,2,3]");
        System.out.println("7. [2]");
        System.out.println("8. [2,3]");
        System.out.println("9. [3]");
    }
}
