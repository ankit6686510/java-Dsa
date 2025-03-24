package lecture_11_Arrays;

import java.util.Scanner;

/**
 * This class demonstrates the basics of array creation and usage
 */
public class ArraysIntro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        
        // Create array with user-specified size
        int[] array = new int[size];
        
        // Read array elements from user input
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Display the array
        display(array);
        
        scanner.close();
    }
    
    /**
     * Displays all elements of an array with spaces between them
     * @param array the array to display
     */
    public static void display(int[] array) {
        System.out.print("Array elements: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

