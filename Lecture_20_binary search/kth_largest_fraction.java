//https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
public class kth_largest_fraction {
    
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            double low = arr[0] / (double) arr[n - 1]; // Smallest fraction
            double high = 1.0; // Largest fraction
    
            while (low < high) {
                double mid = (low + high) / 2; // Midpoint in binary search
                int[] count = countFractions(arr, mid); // Count fractions <= mid
    
                if (k < count[0]) {
                    high = mid; // Adjust search range to the left
                } else if (k > count[0]) {
                    low = mid; // Adjust search range to the right
                } else {
                    return new int[]{count[1], count[2]}; // Found the k-th smallest fraction
                }
            }
            return null; // Default return (should not reach here)
        }
    
        // Helper function to count fractions <= target and track the largest fraction
        private int[] countFractions(int[] arr, double target) {
            int count = 0;
            int i = 0;
            int n = arr.length;
            int num = arr[0], deno = arr[n - 1]; // Track the largest fraction <= target
    
            for (int j = 1; j < n; j++) {
                // Move i to find the largest numerator such that arr[i] / arr[j] <= target
                while (i < j && arr[i] <= arr[j] * target) {
                    i++;
                }
                count += i; // Add the number of valid fractions for this denominator
                if (i > 0 && arr[i - 1] * deno > num * arr[j]) {
                    // Update the largest fraction <= target
                    num = arr[i - 1];
                    deno = arr[j];
                }
            }
            return new int[]{count, num, deno};
        }
    }
