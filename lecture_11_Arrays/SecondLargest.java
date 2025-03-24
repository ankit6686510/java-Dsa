package lecture_11_Arrays;

// import java.util.Scanner;

/**
 * This class finds the second largest element in an array
 */
public class SecondLargest {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int result = findSecondLargest(arr);
        
        if (result == Integer.MIN_VALUE) {
            System.out.println("No second largest element found (all elements are same)");
        } else {
            System.out.println("Second largest element: " + result);
        }
        
        scanner.close();
    }
    
    /**
     * Finds the second largest element in an array
     * @param arr input array
     * @return the second largest element, or Integer.MIN_VALUE if not found
     */
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return Integer.MIN_VALUE; // Not enough elements
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        // First pass to find the largest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        
        // Second pass to find second largest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        
        return secondLargest;
    }
}
