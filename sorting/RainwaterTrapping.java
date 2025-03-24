package sorting;

/**
 * This class solves the Rainwater Trapping problem
 * Given n non-negative integers representing an elevation map,
 * the algorithm computes how much water can be trapped after raining.
 */
public class RainwaterTrapping {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        int trappedWater = trapRainwater(heights);
        System.out.println("Total trapped rainwater: " + trappedWater);
    }
    
    /**
     * Calculates the amount of water that can be trapped between the bars
     * 
     * Algorithm:
     * 1. Find the maximum height to the left for each position
     * 2. Find the maximum height to the right for each position
     * 3. The water trapped at any position is min(leftMax, rightMax) - height[i]
     * 
     * @param heights array representing elevation map
     * @return the total amount of trapped water
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int trapRainwater(int[] heights) {
        if (heights == null || heights.length <= 2) {
            return 0; // Cannot trap water with less than 3 bars
        }
        
        int n = heights.length;
        
        // Calculate left max heights
        int[] leftMax = new int[n];
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        
        // Calculate right max heights
        int[] rightMax = new int[n];
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        
        // Calculate trapped water at each position
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        
        return totalWater;
    }
}
