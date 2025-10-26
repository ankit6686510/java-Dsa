import java.util.*;

public class PizzaTime {
    private static HashMap memo = new HashMap();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
        
        sc.close();
    }
    
    private static int solve(int n) {
        memo.clear();
        return maxSlicesHaoCanEat(n);
    }
    
    private static int maxSlicesHaoCanEat(int slices) {
        // Base cases
        if (slices <= 2) {
            return 0; // Alex eats all remaining slices
        }
        
        if (memo.containsKey(String.valueOf(slices))) {
            return (Integer) memo.get(String.valueOf(slices));
        }
        
        int maxHaoSlices = 0;
        
        // Try all valid partitions (m1, m2, m3)
        // where m1 + m2 + m3 = slices and 1 ≤ m1 ≤ m2 ≤ m3
        for (int m1 = 1; m1 <= slices / 3; m1++) {
            for (int m2 = m1; m2 <= (slices - m1) / 2; m2++) {
                int m3 = slices - m1 - m2;
                
                if (m2 <= m3) {
                    // Hao eats m1 slices today + optimal from remaining m3 slices
                    int totalHaoSlices = m1 + maxSlicesHaoCanEat(m3);
                    maxHaoSlices = Math.max(maxHaoSlices, totalHaoSlices);
                }
            }
        }
        
        memo.put(String.valueOf(slices), maxHaoSlices);
        return maxHaoSlices;
    }
}
