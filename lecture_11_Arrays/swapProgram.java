package lecture_11_Arrays;

/**
 * This class demonstrates Java's pass-by-value behavior
 * Note: This swap function will not actually swap the original values
 * because Java passes primitive types by value, not by reference
 */
public class swapProgram {
    public static void main(String[] args) {
        int[] array = {10, 20, 5, 7, 8};
        
        System.out.println("Before attempt to swap: " + array[0] + " " + array[1]);
        
        // This won't actually swap the array elements because of pass-by-value
        swap(array[0], array[1]);
        
        System.out.println("After attempt to swap: " + array[0] + " " + array[1]);
        
        // Correct way to swap array elements
        System.out.println("\nProper way to swap array elements:");
        System.out.println("Before swap: " + array[0] + " " + array[1]);
        
        swapArrayElements(array, 0, 1);
        
        System.out.println("After swap: " + array[0] + " " + array[1]);
    }
    
    /**
     * This method attempts to swap two integers
     * Note: This won't work for the original values due to pass-by-value
     * 
     * @param a first integer
     * @param b second integer
     */
    public static void swap(int a, int b) {
        System.out.println("Inside swap method, swapping " + a + " and " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swap method, after swap: " + a + " " + b);
    }
    
    /**
     * Correct way to swap elements in an array
     * 
     * @param array the array containing elements to swap
     * @param i index of first element
     * @param j index of second element
     */
    public static void swapArrayElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
