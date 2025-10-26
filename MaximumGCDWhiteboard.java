import java.util.*;

public class MaximumGCDWhiteboard {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            
            System.out.println(solve(arr, n, k));
        }
        sc.close();
    }
    
    private static long solve(long[] arr, int n, int k) {
        // Calculate total sum
        long totalSum = 0;
        for (long num : arr) {
            totalSum += num;
        }
        
        if (k == 0) {
            // No erasures allowed, find GCD of all elements
            long gcd = arr[0];
            for (int i = 1; i < n; i++) {
                gcd = gcd(gcd, arr[i]);
            }
            return gcd;
        }
        
        if (k >= n) {
            return totalSum;
        }
        
        // Try all possible ways to erase k elements
        long maxGCD = 1;
        List<Long> erasedSums = new ArrayList<>();
        generateSubsetSums(arr, 0, 0, k, 0, erasedSums);
        
        for (long erasedSum : erasedSums) {
            long remainingSum = totalSum - erasedSum;
            int remainingCount = n - k;
            
            // Answer for this configuration is gcd(remainingSum, remainingCount)
            long gcd = gcd(remainingSum, remainingCount);
            maxGCD = Math.max(maxGCD, gcd);
        }
        
        return maxGCD;
    }
    
    private static void generateSubsetSums(long[] arr, int start, int count, int target, long currentSum, List<Long> sums) {
        if (count == target) {
            sums.add(currentSum);
            return;
        }
        
        if (start >= arr.length) {
            return;
        }
        
        // Include
        generateSubsetSums(arr, start + 1, count + 1, target, currentSum + arr[start], sums);
        
        // Exclude
        generateSubsetSums(arr, start + 1, count, target, currentSum, sums);
    }
    
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}