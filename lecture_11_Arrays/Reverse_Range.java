package lecture_11_Arrays;
import java.util.Scanner;

/**
 * This class demonstrates how to reverse elements in a specific range of an array
 */
public class Reverse_Range {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        
        int[] array = new int[n];
        
        // Read array elements
        System.out.println("Enter " + n + " array elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Read range to reverse
        System.out.print("Enter start index: ");
        int startIndex = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = scanner.nextInt();
        
        // Reverse the specified range
        reverseRange(array, startIndex, endIndex);
        
        // Display the modified array
        System.out.print("Array after reversing range: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        scanner.close();
    }
    
    /**
     * Reverses elements in an array within the given range (inclusive)
     * 
     * @param array the array to modify
     * @param start starting index of the range (inclusive)
     * @param end ending index of the range (inclusive)
     */
    public static void reverseRange(int[] array, int start, int end) {
        while (start < end) {
            // Swap elements at start and end positions
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            
            // Move indices inward
            start++;
            end--;
        }
    }
}
