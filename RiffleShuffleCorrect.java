import java.util.*;

public class RiffleShuffleCorrect {
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
            result = (result + countWaysForSplit(n, p, k)) % MOD;
        }
        
        return result;
    }
    
    private static long countWaysForSplit(int n, int[] p, int k) {
        // For riffle shuffle with split k:
        // Left deck: 1, 2, ..., k (should appear as subsequence)
        // Right deck: k+1, k+2, ..., n (should appear as subsequence)
        
        // Check if fixed elements are valid for this split
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (p[i] != -1) {
                if (p[i] < 1 || p[i] > n || used.contains(p[i])) {
                    return 0; // Invalid or duplicate
                }
                used.add(p[i]);
            }
        }
        
        // Separate fixed positions into left and right parts
        List<Integer> leftFixed = new ArrayList<>(); // positions with values 1..k
        List<Integer> rightFixed = new ArrayList<>(); // positions with values k+1..n
        
        for (int i = 0; i < n; i++) {
            if (p[i] != -1) {
                if (p[i] <= k) {
                    leftFixed.add(i);
                } else {
                    rightFixed.add(i);
                }
            }
        }
        
        // Check if fixed elements maintain increasing order within their parts
        for (int i = 1; i < leftFixed.size(); i++) {
            if (p[leftFixed.get(i)] <= p[leftFixed.get(i-1)]) {
                return 0;
            }
        }
        
        for (int i = 1; i < rightFixed.size(); i++) {
            if (p[rightFixed.get(i)] <= p[rightFixed.get(i-1)]) {
                return 0;
            }
        }
        
        // Count available values for each part
        int leftAvailable = k - leftFixed.size();
        int rightAvailable = (n - k) - rightFixed.size();
        
        // Count empty positions
        int emptyPositions = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == -1) emptyPositions++;
        }
        
        if (leftAvailable + rightAvailable != emptyPositions) {
            return 0;
        }
        
        // Dynamic Programming
        // dp[i][l][r] = ways to fill first i positions using l left values and r right values
        long[][][] dp = new long[n + 1][leftAvailable + 1][rightAvailable + 1];
        dp[0][0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int l = 0; l <= leftAvailable; l++) {
                for (int r = 0; r <= rightAvailable; r++) {
                    if (dp[i][l][r] == 0) continue;
                    
                    if (p[i] != -1) {
                        // Position is already filled
                        dp[i + 1][l][r] = (dp[i + 1][l][r] + dp[i][l][r]) % MOD;
                    } else {
                        // Empty position - can use left value
                        if (l < leftAvailable) {
                            dp[i + 1][l + 1][r] = (dp[i + 1][l + 1][r] + dp[i][l][r]) % MOD;
                        }
                        // Empty position - can use right value  
                        if (r < rightAvailable) {
                            dp[i + 1][l][r + 1] = (dp[i + 1][l][r + 1] + dp[i][l][r]) % MOD;
                        }
                    }
                }
            }
        }
        
        long result = dp[n][leftAvailable][rightAvailable];
        
        // Multiply by factorials - we can arrange the unused values in any order within their parts
        result = (result * factorial(leftAvailable)) % MOD;
        result = (result * factorial(rightAvailable)) % MOD;
        
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
