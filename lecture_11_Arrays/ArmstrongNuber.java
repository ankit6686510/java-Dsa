package lecture_11_Arrays;

import java.util.Scanner;

/**
 * This class checks if a number is an Armstrong number.
 * An Armstrong number is a number that is equal to the sum of its own digits 
 * each raised to the power of the number of digits.
 * For example, 153 = 1^3 + 5^3 + 3^3
 */
public class ArmstrongNuber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        int number = scanner.nextInt();
        
        boolean isArmstrong = isArmstrongNumber(number);
        
        if (isArmstrong) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        
        scanner.close();
    }

    /**
     * Checks if a number is an Armstrong number
     * 
     * @param number the number to check
     * @return true if the number is an Armstrong number, false otherwise
     */
    public static boolean isArmstrongNumber(int number) {
        // Get the number of digits in the number
        int digitCount = countDigits(number);
        
        int sum = 0;
        int originalNumber = number;
        
        // Calculate the sum of each digit raised to the power of digit count
        while (number > 0) {
            int remainder = number % 10;
            sum += Math.pow(remainder, digitCount);
            number /= 10;
        }
        
        // Check if the sum equals the original number
        return sum == originalNumber;
    }

    /**
     * Counts the number of digits in a number
     * 
     * @param number the number to count digits of
     * @return the number of digits
     */
    public static int countDigits(int number) {
        int count = 0;
        
        while (number > 0) {
            count++;
            number /= 10;
        }
        
        return count;
    }
}
