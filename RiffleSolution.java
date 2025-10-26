import java.util.*;

public class RiffleSolution {
    private static final int MOD = 998244353;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            
            System.out.println(solve(n, p));
        }
        sc.close();
    }
    
    private static long solve(int n, int[] p) {
        long result = 0;
        
        // Try all possible split points k (1 <= k < n)
        for (int k = 1; k < n; k++) {
            result = (result + countForSplit(n, p, k)) % MOD;
        }
        
        return result;
    }
    
    private static long countForSplit(int n, int[] p, int k) {
        // Validate and prepare
        boolean[] used = new boolean[n + 1];
        int leftFixed = 0, rightFixed = 0;
        
        for (int i = 0; i < n; i++) {
            if (p[i] != -1) {
                if (p[i] < 1 || p[i] > n || used[p[i]]) {
                    return 0; // Invalid
                }
                used[p[i]] = true;
                
                if (p[i] <= k) leftFixed++;
                else rightFixed++;
            }
        }
        
        // Check subsequence property for fixed elements
        int[] leftVals = new int[leftFixed];
        int[] rightVals = new int[rightFixed];
        int leftIdx = 0, rightIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (p[i] != -1) {
                if (p[i] <= k) {
                    leftVals[leftIdx++] = p[i];
                } else {
                    rightVals[rightIdx++] = p[i];
                }
            }
        }
        
        // Check if fixed elements are in increasing order
        for (int i = 1; i < leftFixed; i++) {
            if (leftVals[i] <= leftVals[i-1]) return 0;
        }
        
        for (int i = 1; i < rightFixed; i++) {
            if (rightVals[i] <= rightVals[i-1]) return 0;
        }
        
        // Count remaining elements
        int leftRemaining = k - leftFixed;
        int rightRemaining = (n - k) - rightFixed;
        
        // Count empty positions
        int emptyCount = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == -1) emptyCount++;
        }
        
        if (leftRemaining + rightRemaining != emptyCount) {
            return 0;
        }
        
        // DP to count ways to place remaining elements
        // dp[i][l][r] = ways to fill first i empty positions using l left and r right elements
        long[][][] dp = new long[emptyCount + 1][leftRemaining + 1][rightRemaining + 1];
        dp[0][0][0] = 1;
        
        for (int i = 0; i < emptyCount; i++) {
            for (int l = 0; l <= leftRemaining; l++) {
                for (int r = 0; r <= rightRemaining; r++) {
                    if (dp[i][l][r] == 0) continue;
                    
                    // Place a left element
                    if (l < leftRemaining) {
                        dp[i + 1][l + 1][r] = (dp[i + 1][l + 1][r] + dp[i][l][r]) % MOD;
                    }
                    
                    // Place a right element
                    if (r < rightRemaining) {
                        dp[i + 1][l][r + 1] = (dp[i + 1][l][r + 1] + dp[i][l][r]) % MOD;
                    }
                }
            }
        }
        
        // Multiply by factorials (arrangements within each part)
        long result = dp[emptyCount][leftRemaining][rightRemaining];
        result = (result * factorial(leftRemaining)) % MOD;
        result = (result * factorial(rightRemaining)) % MOD;
        
        return result;
    }
    
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}
