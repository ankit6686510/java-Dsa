import java.util.*;
import java.io.*;

public class BestTimeToBuyAndSellStock {
    
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
        // For the game theory approach:
        // Hao wants to minimize beauty, Alex wants to maximize beauty
        // With optimal play, we need to determine the final beauty
        
        // Key insight: exactly n/2 elements will remain locked
        // We need to find what those n/2 elements will be with optimal play
        
        // Create pairs of (value, original_index)
        List<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(a[i], i));
        }
        
        // Sort by value
        Collections.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.value < b.value) return -1;
                if (a.value > b.value) return 1;
                return 0;
            }
        });
        
        // For optimal play analysis:
        // Hao will try to remove high values that could be the maximum in a pair
        // Alex will try to lock values that can form good pairs
        
        // Simulate the game with optimal strategy
        boolean[] removed = new boolean[n];
        boolean[] locked = new boolean[n];
        
        // Use greedy approach for optimal play
        return simulateOptimalGame(pairs, n);
    }
    
    public static long simulateOptimalGame(List<Pair> pairs, int n) {
        // For small arrays, we can try all possible strategies
        if (n <= 10) {
            return bruteForceOptimal(pairs, 0, new boolean[n], new boolean[n], true, n);
        }
        
        // For larger arrays, use heuristic approach
        return heuristicSolution(pairs, n);
    }
    
    public static long bruteForceOptimal(List<Pair> pairs, int turn, boolean[] removed, boolean[] locked, boolean haoTurn, int n) {
        if (turn == n) {
            return calculateFinalBeauty(pairs, removed, locked, n);
        }
        
        if (haoTurn) {
            // Hao's turn - minimize beauty
            long minBeauty = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!removed[i] && !locked[i]) {
                    removed[i] = true;
                    long beauty = bruteForceOptimal(pairs, turn + 1, removed, locked, false, n);
                    minBeauty = Math.min(minBeauty, beauty);
                    removed[i] = false;
                }
            }
            return minBeauty == Long.MAX_VALUE ? calculateFinalBeauty(pairs, removed, locked, n) : minBeauty;
        } else {
            // Alex's turn - maximize beauty
            long maxBeauty = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (!removed[i] && !locked[i]) {
                    locked[i] = true;
                    long beauty = bruteForceOptimal(pairs, turn + 1, removed, locked, true, n);
                    maxBeauty = Math.max(maxBeauty, beauty);
                    locked[i] = false;
                }
            }
            return maxBeauty == Long.MIN_VALUE ? calculateFinalBeauty(pairs, removed, locked, n) : maxBeauty;
        }
    }
    
    public static long heuristicSolution(List<Pair> pairs, int n) {
        // Heuristic: Hao will target removing elements that could form maximum differences
        // Alex will try to lock elements that can form good pairs
        
        boolean[] removed = new boolean[n];
        boolean[] locked = new boolean[n];
        
        // Convert back to array indexed by original position
        long[] arr = new long[n];
        for (Pair p : pairs) {
            arr[p.index] = p.value;
        }
        
        // Simulate turns
        for (int turn = 0; turn < n; turn++) {
            if (turn % 2 == 0) {
                // Hao's turn - remove element that maximizes potential beauty reduction
                haoOptimalMove(arr, removed, locked, n);
            } else {
                // Alex's turn - lock element that maximizes potential beauty
                alexOptimalMove(arr, removed, locked, n);
            }
        }
        
        return calculateBeauty(arr, locked, n);
    }
    
    public static void haoOptimalMove(long[] arr, boolean[] removed, boolean[] locked, int n) {
        int bestRemove = -1;
        long maxImpact = Long.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (!removed[i] && !locked[i]) {
                // Calculate potential impact of removing this element
                long impact = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i && !removed[j]) {
                        if (i < j) {
                            impact += arr[j] - arr[i];
                        } else {
                            impact += arr[i] - arr[j];
                        }
                    }
                }
                
                if (impact > maxImpact) {
                    maxImpact = impact;
                    bestRemove = i;
                }
            }
        }
        
        if (bestRemove != -1) {
            removed[bestRemove] = true;
        }
    }
    
    public static void alexOptimalMove(long[] arr, boolean[] removed, boolean[] locked, int n) {
        int bestLock = -1;
        long maxBeautyContribution = Long.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (!removed[i] && !locked[i]) {
                // Calculate beauty contribution if we lock this element
                long contribution = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i && !removed[j]) {
                        if (i < j) {
                            contribution = Math.max(contribution, arr[j] - arr[i]);
                        } else {
                            contribution = Math.max(contribution, arr[i] - arr[j]);
                        }
                    }
                }
                
                if (contribution > maxBeautyContribution) {
                    maxBeautyContribution = contribution;
                    bestLock = i;
                }
            }
        }
        
        if (bestLock != -1) {
            locked[bestLock] = true;
        }
    }
    
    public static long calculateFinalBeauty(List<Pair> pairs, boolean[] removed, boolean[] locked, int n) {
        List<Pair> finalElements = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            if (locked[i]) {
                finalElements.add(pairs.get(i));
            }
        }
        
        if (finalElements.size() < 2) {
            return 0;
        }
        
        // Sort by original index
        Collections.sort(finalElements, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return Integer.compare(a.index, b.index);
            }
        });
        
        long maxBeauty = Long.MIN_VALUE;
        for (int i = 0; i < finalElements.size(); i++) {
            for (int j = i + 1; j < finalElements.size(); j++) {
                maxBeauty = Math.max(maxBeauty, finalElements.get(j).value - finalElements.get(i).value);
            }
        }
        
        return maxBeauty;
    }
    
    public static long calculateBeauty(long[] arr, boolean[] locked, int n) {
        List<Integer> lockedIndices = new ArrayList<Integer>();
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
                maxBeauty = Math.max(maxBeauty, arr[idx2] - arr[idx1]);
            }
        }
        
        return maxBeauty;
    }
    
    static class Pair {
        long value;
        int index;
        
        Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
