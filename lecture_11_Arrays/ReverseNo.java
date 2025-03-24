package lecture_11_Arrays;

/**
 * This class demonstrates how to reverse the order of elements in an array
 */
public class ReverseNo {
    public static void main(String[] args) {
        // Sample array to reverse
        int[] array = {1, 2, 3, 4, 5};
        
        System.out.print("Original array: ");
        printArray(array);
        
        // Reverse the array
        reverse(array);
        
        System.out.print("Reversed array: ");
        printArray(array);
    }
    
    /**
     * Reverses the order of elements in an array in-place
     * 
     * @param array the array to be reversed
     */
    public static void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        
        // Swap elements from both ends until we reach the middle
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
    
    /**
     * Helper method to print an array
     * 
     * @param array the array to be printed
     */
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
