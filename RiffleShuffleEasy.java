import java.util.*;

public class RiffleShuffleEasy {
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
            result = (result + countValidFillings(n, p, k)) % MOD;
        }
        
        return result;
    }
    
    private static long countValidFillings(int n, int[] p, int k) {
        // For split k: left=[1..k], right=[k+1..n]
        
        // Validate existing elements and collect positions
        Set<Integer> used = new HashSet<>();
        List<Integer> leftElements = new ArrayList<>(); // values 1..k
        List<Integer> rightElements = new ArrayList<>(); // values k+1..n
        List<Integer> leftPositions = new ArrayList<>(); // positions of left elements
        List<Integer> rightPositions = new ArrayList<>(); // positions of right elements
        
        for (int i = 0; i < n; i++) {
            if (p[i] != -1) {
                if (used.contains(p[i])) return 0; // duplicate
                used.add(p[i]);
                
                if (p[i] >= 1 && p[i] <= k) {
                    leftElements.add(p[i]);
                    leftPositions.add(i);
                } else if (p[i] >= k + 1 && p[i] <= n) {
                    rightElements.add(p[i]);
                    rightPositions.add(i);
                } else {
                    return 0; // invalid value
                }
            }
        }
        
        // Check if left elements are in increasing order
        for (int i = 1; i < leftElements.size(); i++) {
            if (leftElements.get(i) <= leftElements.get(i-1)) return 0;
        }
        
        // Check if right elements are in increasing order
        for (int i = 1; i < rightElements.size(); i++) {
            if (rightElements.get(i) <= rightElements.get(i-1)) return 0;
        }
        
        // Calculate available numbers
        Set<Integer> availableLeft = new HashSet<>();
        Set<Integer> availableRight = new HashSet<>();
        
        for (int i = 1; i <= k; i++) {
            if (!used.contains(i)) availableLeft.add(i);
        }
        
        for (int i = k + 1; i <= n; i++) {
            if (!used.contains(i)) availableRight.add(i);
        }
        
        int leftCount = availableLeft.size();
        int rightCount = availableRight.size();
        
        // Count empty positions
        int emptyCount = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == -1) emptyCount++;
        }
        
        if (leftCount + rightCount != emptyCount) return 0;
        
        // DP to count ways to assign elements to positions
        // dp[pos][usedLeft][usedRight] = ways to fill positions 0..pos-1
        long[][][] dp = new long[n + 1][leftCount + 1][rightCount + 1];
        dp[0][0][0] = 1;
        
        for (int pos = 0; pos < n; pos++) {
            for (int usedLeft = 0; usedLeft <= leftCount; usedLeft++) {
                for (int usedRight = 0; usedRight <= rightCount; usedRight++) {
                    if (dp[pos][usedLeft][usedRight] == 0) continue;
                    
                    if (p[pos] != -1) {
                        // Position is already filled
                        dp[pos + 1][usedLeft][usedRight] = 
                            (dp[pos + 1][usedLeft][usedRight] + dp[pos][usedLeft][usedRight]) % MOD;
                    } else {
                        // Position is empty, try placing from left
                        if (usedLeft < leftCount) {
                            dp[pos + 1][usedLeft + 1][usedRight] = 
                                (dp[pos + 1][usedLeft + 1][usedRight] + dp[pos][usedLeft][usedRight]) % MOD;
                        }
                        
                        // Try placing from right
                        if (usedRight < rightCount) {
                            dp[pos + 1][usedLeft][usedRight + 1] = 
                                (dp[pos + 1][usedLeft][usedRight + 1] + dp[pos][usedLeft][usedRight]) % MOD;
                        }
                    }
                }
            }
        }
        
        // Result is number of ways times factorial of each part
        long ways = dp[n][leftCount][rightCount];
        ways = (ways * factorial(leftCount)) % MOD;
        ways = (ways * factorial(rightCount)) % MOD;
        
        return ways;
    }
    
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}
