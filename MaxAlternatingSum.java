import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        // Square all numbers and convert to long to avoid overflow
        long[] squares = new long[n];
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        // Sort the squared values
        Arrays.sort(squares);
        
        // Calculate the alternating sum
        // Put largest values at even positions (positive contribution)
        // Put smallest values at odd positions (negative contribution)
        
        long sum = 0;
        
        // Number of positive positions (0, 2, 4, ...) = (n + 1) / 2
        // Number of negative positions (1, 3, 5, ...) = n / 2
        
        int positiveCount = (n + 1) / 2;
        int negativeCount = n / 2;
        
        // Sum of largest 'positiveCount' elements (from the end)
        for (int i = n - positiveCount; i < n; i++) {
            sum += squares[i];
        }
        
        // Subtract sum of smallest 'negativeCount' elements (from the beginning)
        for (int i = 0; i < negativeCount; i++) {
            sum -= squares[i];
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: [1, 2, 3]
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.maxAlternatingSum(nums1));
        System.out.println("Expected: 12");
        System.out.println();
        
        // Test case 2: [1, -1, 2, -2, 3, -3]
        int[] nums2 = {1, -1, 2, -2, 3, -3};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.maxAlternatingSum(nums2));
        System.out.println("Expected: 16");
        System.out.println();
        
        // Additional test cases
        int[] nums3 = {5};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.maxAlternatingSum(nums3));
        System.out.println("Expected: 25");
        System.out.println();
        
        int[] nums4 = {-5, 10};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + solution.maxAlternatingSum(nums4));
        System.out.println("Expected: 75 (100 - 25)");
    }
}
