import java.util.*;
import java.io.*;

public class BestTimeToBuyAndSellStockFinal {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            long[] a = new long[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(input[i]);
            }
            
            System.out.println(solve(a, n));
        }
    }
    
    public static long solve(long[] a, int n) {
        // Game theory problem: Hao minimizes beauty, Alex maximizes beauty
        // Both play optimally, exactly n/2 elements remain locked
        
        if (n == 2) {
            // Special case: only one element will be locked, beauty is 0 if < 2 elements
            return 0;
        }
        
        if (n <= 8) {
            // For small arrays, use exact minimax with pruning
            return minimaxSolution(a, n);
        } else {
            // For larger arrays, use strategic heuristic
            return heuristicSolution(a, n);
        }
    }
    
    public static long minimaxSolution(long[] a, int n) {
        // Use minimax algorithm for exact solution on small inputs
        boolean[] removed = new boolean[n];
        boolean[] locked = new boolean[n];
        return minimax(a, removed, locked, 0, true, n);
    }
    
    public static long minimax(long[] a, boolean[] removed, boolean[] locked, int turn, boolean haoTurn, int n) {
        if (turn == n) {
            return calculateBeauty(a, locked, n);
        }
        
        if (haoTurn) {
            // Hao's turn - minimize beauty
            long minResult = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!removed[i] && !locked[i]) {
                    removed[i] = true;
                    long result = minimax(a, removed, locked, turn + 1, false, n);
                    minResult = Math.min(minResult, result);
                    removed[i] = false;
                }
            }
            return minResult == Long.MAX_VALUE ? calculateBeauty(a, locked, n) : minResult;
        } else {
            // Alex's turn - maximize beauty
            long maxResult = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (!removed[i] && !locked[i]) {
                    locked[i] = true;
                    long result = minimax(a, removed, locked, turn + 1, true, n);
                    maxResult = Math.max(maxResult, result);
                    locked[i] = false;
                }
            }
            return maxResult == Long.MIN_VALUE ? calculateBeauty(a, locked, n) : maxResult;
        }
    }
    
    public static long heuristicSolution(long[] a, int n) {
        // Strategic approach for larger arrays
        boolean[] removed = new boolean[n];
        boolean[] locked = new boolean[n];
        
        // Simulate optimal gameplay
        for (int turn = 0; turn < n; turn++) {
            if (turn % 2 == 0) {
                // Hao's turn: remove element that hurts Alex's potential the most
                haoOptimalMove(a, removed, locked, n);
            } else {
                // Alex's turn: lock element that gives best beauty potential
                alexOptimalMove(a, removed, locked, n);
            }
        }
        
        return calculateBeauty(a, locked, n);
    }
    
    public static void haoOptimalMove(long[] a, boolean[] removed, boolean[] locked, int n) {
        int bestMove = -1;
        long maxDamage = Long.MIN_VALUE;
        
        // Find element whose removal maximally reduces potential beauty
        for (int i = 0; i < n; i++) {
            if (!removed[i] && !locked[i]) {
                long damage = 0;
                
                // Calculate potential beauty reduction from removing element i
                for (int j = 0; j < n; j++) {
                    if (j != i && !removed[j] && !locked[j]) {
                        if (i < j) {
                            damage += Math.max(0, a[j] - a[i]);
                        } else {
                            damage += Math.max(0, a[i] - a[j]);
                        }
                    }
                }
                
                if (damage > maxDamage) {
                    maxDamage = damage;
                    bestMove = i;
                }
            }
        }
        
        if (bestMove != -1) {
            removed[bestMove] = true;
        }
    }
    
    public static void alexOptimalMove(long[] a, boolean[] removed, boolean[] locked, int n) {
        int bestMove = -1;
        long maxContribution = Long.MIN_VALUE;
        
        // Find element that contributes most to potential beauty when locked
        for (int i = 0; i < n; i++) {
            if (!removed[i] && !locked[i]) {
                long contribution = 0;
                
                // Calculate maximum beauty this element can contribute to
                for (int j = 0; j < n; j++) {
                    if (j != i && !removed[j]) {
                        if (i < j) {
                            contribution = Math.max(contribution, a[j] - a[i]);
                        } else {
                            contribution = Math.max(contribution, a[i] - a[j]);
                        }
                    }
                }
                
                if (contribution > maxContribution) {
                    maxContribution = contribution;
                    bestMove = i;
                }
            }
        }
        
        if (bestMove != -1) {
            locked[bestMove] = true;
        }
    }
    
    public static long calculateBeauty(long[] a, boolean[] locked, int n) {
        // Find all locked elements and calculate maximum beauty
        List<Integer> lockedIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (locked[i]) {
                lockedIndices.add(i);
            }
        }
        
        if (lockedIndices.size() < 2) {
            return 0;
        }
        
        long maxBeauty = Long.MIN_VALUE;
        for (int i = 0; i < lockedIndices.size(); i++) {
            for (int j = i + 1; j < lockedIndices.size(); j++) {
                int idx1 = lockedIndices.get(i);
                int idx2 = lockedIndices.get(j);
                // Beauty is max difference where j > i
                maxBeauty = Math.max(maxBeauty, a[idx2] - a[idx1]);
            }
        }
        
        return maxBeauty;
    }
}
