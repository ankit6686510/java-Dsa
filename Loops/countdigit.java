public class CountDigits {
    public int countDigits(int n) {
        int count = 0; // Step 1: Initialize count to 0
        while (n != 0) { // Step 2: Loop until n is 0
            n /= 10; // Step 3: Remove last digit from n
            count++; // Step 4: Increment count
        }
        return count; // Step 5: Return digit count
    }
}
