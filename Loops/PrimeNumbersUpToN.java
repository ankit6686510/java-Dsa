import java.util.Scanner;

public class PrimeNumbersUpToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int N = scanner.nextInt();

        System.out.println("Prime numbers up to " + N + ":");
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}
