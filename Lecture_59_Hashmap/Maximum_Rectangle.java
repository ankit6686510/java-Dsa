package Lecture_59_Hashmap;

import java.util.Stack;
// https://leetcode.com/problems/maximal-rectangle/submissions/1704692893/

public class Maximum_Rectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Histogram height for each column
        int[] heights = new int[cols];

        for (int i = 0; i < rows; i++) {
            // Step 1: Build/update the histogram for current row
            for (int j = 0; j < cols; j++) {
                // If current cell is '1', add 1 to height, else reset to 0
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Step 2: Find largest rectangle area in histogram for this row
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Function to calculate largest rectangle area in a histogram
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Traverse all bars in histogram
        for (int i = 0; i <= n; i++) {
            // Use 0 height as sentinel at end
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // height of the bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // width of rectangle
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
