public class ChefandDivisors {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt(); // Read number of test cases
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(); // Read input number
            int count = 0; // Initialize counter
            
            // Count divisors
            for (int j = 1; j * j <= x; j++) {
                if (x % j == 0) {
                    count += (j == x/j) ? 1 : 2; // Add 1 or 2 depending on if j is a perfect square
                }
            }
            
            System.out.println(count); // Print result
        }
        
        sc.close(); // Close scanner
    }
}
