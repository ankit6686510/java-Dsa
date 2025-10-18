import java.util.Scanner;

public class TrilobyteSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        // Find the smallest non-negative integer k such that 
        // when k is appended to n, the result is a multiple of 8
        int result = findSmallestK(n);
        System.out.println(result);
        
        scanner.close();
    }
    
    public static int findSmallestK(int n) {
        // Try k from 0 to infinity until we find one that works
        for (int k = 0; k < 1000; k++) { // 1000 should be enough for this problem
            // Convert n to string and append k
            String nStr = String.valueOf(n);
            String kStr = String.valueOf(k);
            String combined = nStr + kStr;
            
            // Convert back to long to check divisibility by 8
            long combinedNum = Long.parseLong(combined);
            
            if (combinedNum % 8 == 0) {
                return k;
            }
        }
        
        return -1; // Should never reach here for valid input
    }
}
