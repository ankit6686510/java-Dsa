import java.util.*;

public class PizzaTimeOptimized {
    
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
        if (n <= 2) {
            return 0;
        }
        
        int total = 0;
        
        while (n > 2) {
            if (n % 3 == 0) {
                // n = 3k, partition as (k, k, k)
                int k = n / 3;
                total += k;
                n = k;
            } else if (n % 3 == 1) {
                // n = 3k + 1, partition as (k, k, k+1) 
                int k = n / 3;
                total += k;
                n = k + 1;
            } else {
                // n % 3 == 2, n = 3k + 2, partition as (k, k+1, k+1)
                int k = n / 3;
                total += k;
                n = k + 1;
            }
        }
        
        return total;
    }
}
