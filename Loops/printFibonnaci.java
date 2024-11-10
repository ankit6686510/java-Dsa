public class FibonacciSeries {
    public void printFibonacci(int n) {
        int first = 0, second = 1; // Step 1: Initialize first two terms
        for (int i = 0; i < n; i++) { // Step 2: Loop to print n terms
            System.out.print(first + " "); // Step 3: Print current term
            int next = first + second; // Step 4: Calculate next term
            first = second; // Step 5: Shift terms for next iteration
            second = next;
        }
    }
}
