class Find_Pivot_Index {

    //https://www.youtube.com/watch?v=AH-YhFNJoas&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=5
    //https://leetcode.com/problems/find-pivot-index/description/   
    
    public int pivotIndex(int[] nums) {
        int sum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;  // Initialize left sum to 0

        for (int i = 0; i < nums.length; i++) {
            // Right sum will be the remaining part of the total sum minus the current element and left sum
            int rightSum = sum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;   // Return the pivot index if the condition is satisfied
            }

            leftSum += nums[i];  // Add the current element to the left sum
        }

        return -1;  // If no pivot index is found, return -1
    }
}
