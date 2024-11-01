import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int N = scanner.nextInt();   // Taking input from the user
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += i;    // Add i to the sum in each iteration
        }

        System.out.println("Sum of first " + N + " natural numbers is: " + sum);
        scanner.close();
    }
}
// Explanation:
// sum starts from 0, and each i from 1 to N is added to it in the loop.
// The final result gives the sum of numbers from 1 to N.