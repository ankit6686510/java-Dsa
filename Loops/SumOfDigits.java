import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int sum = 0;

        while (num != 0) {
            int lastDigit = num % 10;   // Get the last digit
            sum += lastDigit;           // Add the last digit to sum
            num /= 10;                  // Remove the last digit from num
        }

        System.out.println("Sum of digits: " + sum);
    }
}
