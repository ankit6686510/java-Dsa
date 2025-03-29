public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;  // Edge case: k <= 1 me koi valid subarray nahi hoga
        
        int si = 0;         
        int ei = 0;        
        int p = 1; // Window ka product
        int ans = 0; // Valid subarrays ka count

        while (ei < nums.length) {
            // Growing window
            p *= nums[ei];

            // Shrink the window if product >= k
            while (p >= k && si <= ei) {
                p /= nums[si];    // Left side se window chhoti karo
                si++;
            }

            // Calculate the valid subarrays ending at `ei`
            ans += (ei - si + 1);  

            // Move `ei` to expand the window
            ei++;
        }

        return ans;  // Loop complete hone ke baad result return karo
    }
    
}
