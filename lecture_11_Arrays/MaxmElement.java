package lecture_11_Arrays;

/**
 * This class demonstrates different ways to find the maximum element in an array
 */
public class MaxmElement {
    public static void main(String[] args) {
        int[] array = {1, 5, 8, 7, 9, 6};
        
        System.out.println("Array: 1, 5, 8, 7, 9, 6");
        System.out.println("Maximum element (using first element as initial max): " + findMaxFromFirst(array));
        System.out.println("Maximum element (using Integer.MIN_VALUE as initial max): " + findMaxFromMinValue(array));
    }
    
    /**
     * Finds the maximum element in an array using the first element as the initial maximum
     * 
     * @param array the input array
     * @return the maximum element in the array
     */
    public static int findMaxFromFirst(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int max = array[0]; // Start with the first element
        
        // Compare with remaining elements
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        return max;
    }
    
    /**
     * Finds the maximum element in an array using Integer.MIN_VALUE as the initial maximum
     * 
     * @param array the input array
     * @return the maximum element in the array
     */
    public static int findMaxFromMinValue(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int max = Integer.MIN_VALUE; // Start with the smallest possible integer
        
        // Compare with all elements
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        return max;
    }
}
