public class container_with_most_no_of_water {
    // https://leetcode.com/problems/container-with-most-water/description/
   
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
       
            int area = Math.min(height[left], height[right]) * (right - left);

            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }



    
}
