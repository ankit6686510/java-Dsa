import java.util.*;

public class Notelock {
    
    public static int minProtections(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[] protected_pos = new boolean[n];
        int protections = 0;
        
        // Process karna hai each position from left to right
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                // Check if this position can be changed by Teto
                if (canBeChanged(arr, protected_pos, i, k)) {
                    // We need to protect this position
                    protected_pos[i] = true;
                    protections++;
                }
            }
        }
        
        return protections;
    }
    
    private static boolean canBeChanged(char[] arr, boolean[] protected_pos, int pos, int k) {
        // Position can be changed if:
        // 1. arr[pos] == '1' (already checked)
        // 2. pos is not protected
        // 3. Previous k-1 elements do not contain '1'
        
        if (protected_pos[pos]) {
            return false; // Already protected
        }
        
        // Check karo if there's a '1' in the previous k-1 elements
        int start = Math.max(0, pos - k + 1);
        for (int i = start; i < pos; i++) {
            if (arr[i] == '1') {
                return false; // Cannot be changed due to previous '1'
            }
        }
        
        return true; // Can be changed, so needs protection
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            
            System.out.println(minProtections(s, k));
        }
        
        sc.close();
    }
}
