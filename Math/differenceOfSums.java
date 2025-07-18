public class differenceOfSums {
    // Time Complexity: O(n), Space Complexity: O(1)
    public int differenceOfSumss(int n, int m) {
        int divisibleSum = 0;
        int nonDivisibleSum = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                divisibleSum += i;
            } else {
                nonDivisibleSum += i;
            }
        }
        
        return nonDivisibleSum - divisibleSum;
    }
}
