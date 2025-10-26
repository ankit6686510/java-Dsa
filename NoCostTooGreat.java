import java.util.*;
import java.io.*;

public class NoCostTooGreat {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            
            String[] aStr = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(aStr[i]);
            }
            
            String[] bStr = br.readLine().trim().split(" ");
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(bStr[i]);
            }
            
            System.out.println(solve(a, b, n));
        }
    }
    
    public static long solve(int[] a, int[] b, int n) {
        long minCost = Long.MAX_VALUE;
        
        // Try all pairs (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate cost to make gcd(a[i], a[j]) > 1
                long cost = getMinCostForPair(a[i], a[j], b[i], b[j]);
                minCost = Math.min(minCost, cost);
                
                // Early exit if we find a zero-cost solution
                if (minCost == 0) return 0;
            }
        }
        
        return minCost;
    }
    
    private static long getMinCostForPair(int a1, int a2, int b1, int b2) {
        // Check if they already have gcd > 1
        if (gcd(a1, a2) > 1) {
            return 0;
        }
        
        long minCost = Long.MAX_VALUE;
        
        // Try making both numbers divisible by small primes
        // Only check small primes since larger primes are expensive
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        
        for (int prime : primes) {
            long cost1 = getCostToDivisible(a1, prime, b1);
            long cost2 = getCostToDivisible(a2, prime, b2);
            
            minCost = Math.min(minCost, cost1 + cost2);
        }
        
        return minCost;
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private static long getCostToDivisible(int num, int divisor, int cost) {
        // Calculate minimum cost to make num divisible by divisor
        int remainder = num % divisor;
        if (remainder == 0) {
            return 0; // Already divisible
        }
        
        // Need to add (divisor - remainder) to make it divisible
        return (long) (divisor - remainder) * cost;
    }
}
