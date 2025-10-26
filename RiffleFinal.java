import java.util.*;

public class RiffleFinal {
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
            result = (result + solveForSplit(n, p, k)) % MOD;
        }
        
        return result;
    }
    
    private static long solveForSplit(int n, int[] p, int k) {
        // For split k: left deck [1..k], right deck [k+1..n]
        // We need to count ways to fill -1s such that:
        // 1. All values 1..n appear exactly once
        // 2. Values 1..k appear in increasing order (as subsequence)
        // 3. Values k+1..n appear in increasing order (as subsequence)
        
        // Check current constraints
        boolean[] used = new boolean[n + 1];
        List<Integer> leftPositions = new ArrayList<>();
        List<Integer> rightPositions = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (p[i] != -1) {
                if (p[i] < 1 || p[i] > n || used[p[i]]) {
                    return 0; // Invalid
                }
                used[p[i]] = true;
                
                if (p[i] <= k) {
                    leftPositions.add(i);
                } else {
                    rightPositions.add(i);
                }
            }
        }
        
        // Check if existing values maintain order
        for (int i = 1; i < leftPositions.size(); i++) {
            if (p[leftPositions.get(i)] <= p[leftPositions.get(i-1)]) {
                return 0;
            }
        }
        
        for (int i = 1; i < rightPositions.size(); i++) {
            if (p[rightPositions.get(i)] <= p[rightPositions.get(i-1)]) {
                return 0;
            }
        }
        
        // Count missing values
        List<Integer> missingLeft = new ArrayList<>();
        List<Integer> missingRight = new ArrayList<>();
        
        for (int i = 1; i <= k; i++) {
            if (!used[i]) missingLeft.add(i);
        }
        
        for (int i = k + 1; i <= n; i++) {
            if (!used[i]) missingRight.add(i);
        }
        
        // Count empty positions
        List<Integer> emptyPositions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (p[i] == -1) emptyPositions.add(i);
        }
        
        if (missingLeft.size() + missingRight.size() != emptyPositions.size()) {
            return 0;
        }
        
        // Use DP to count valid ways to assign missing values to empty positions
        // such that subsequence order is maintained
        int leftMissing = missingLeft.size();
        int rightMissing = missingRight.size();
        
        // dp[pos][leftUsed][rightUsed] = ways to assign to first pos empty positions
        long[][][] dp = new long[emptyPositions.size() + 1][leftMissing + 1][rightMissing + 1];
        dp[0][0][0] = 1;
        
        for (int pos = 0; pos < emptyPositions.size(); pos++) {
            for (int leftUsed = 0; leftUsed <= leftMissing; leftUsed++) {
                for (int rightUsed = 0; rightUsed <= rightMissing; rightUsed++) {
                    if (dp[pos][leftUsed][rightUsed] == 0) continue;
                    
                    int currentPos = emptyPositions.get(pos);
                    
                    // Try placing a left value
                    if (leftUsed < leftMissing) {
                        if (canPlaceLeft(p, currentPos, leftPositions, rightPositions, 
                                       missingLeft.get(leftUsed), k)) {
                            dp[pos + 1][leftUsed + 1][rightUsed] = 
                                (dp[pos + 1][leftUsed + 1][rightUsed] + dp[pos][leftUsed][rightUsed]) % MOD;
                        }
                    }
                    
                    // Try placing a right value
                    if (rightUsed < rightMissing) {
                        if (canPlaceRight(p, currentPos, leftPositions, rightPositions, 
                                        missingRight.get(rightUsed), k)) {
                            dp[pos + 1][leftUsed][rightUsed + 1] = 
                                (dp[pos + 1][leftUsed][rightUsed + 1] + dp[pos][leftUsed][rightUsed]) % MOD;
                        }
                    }
                }
            }
        }
        
        return dp[emptyPositions.size()][leftMissing][rightMissing];
    }
    
    private static boolean canPlaceLeft(int[] p, int pos, List<Integer> leftPositions, 
                                      List<Integer> rightPositions, int value, int k) {
        // Check if placing this left value at pos maintains subsequence order
        
        // Find previous left value position
        int prevLeftValue = 0;
        for (int leftPos : leftPositions) {
            if (leftPos < pos) {
                prevLeftValue = Math.max(prevLeftValue, p[leftPos]);
            }
        }
        
        // Find next left value position
        int nextLeftValue = k + 1;
        for (int leftPos : leftPositions) {
            if (leftPos > pos) {
                nextLeftValue = Math.min(nextLeftValue, p[leftPos]);
            }
        }
        
        return value > prevLeftValue && value < nextLeftValue;
    }
    
    private static boolean canPlaceRight(int[] p, int pos, List<Integer> leftPositions, 
                                       List<Integer> rightPositions, int value, int k) {
        // Check if placing this right value at pos maintains subsequence order
        
        // Find previous right value position
        int prevRightValue = k;
        for (int rightPos : rightPositions) {
            if (rightPos < pos) {
                prevRightValue = Math.max(prevRightValue, p[rightPos]);
            }
        }
        
        // Find next right value position
        int nextRightValue = Integer.MAX_VALUE;
        for (int rightPos : rightPositions) {
            if (rightPos > pos) {
                nextRightValue = Math.min(nextRightValue, p[rightPos]);
            }
        }
        
        return value > prevRightValue && value < nextRightValue;
    }
}
