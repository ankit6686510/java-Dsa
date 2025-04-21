public class PrimeSieveOptimized {
    public static void main(String[] args) {
        primesieve(100);
    }

    public static void primesieve(int n) {
        boolean[] prime = new boolean[n + 1];

        // Step 1: Assume all numbers >= 2 are prime
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        // Step 2: Sieve logic - optimized version
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                // Start from i*i instead of i*2
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Step 3: Print prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.println(i + " is a prime number");
            }
        }
    }
}
