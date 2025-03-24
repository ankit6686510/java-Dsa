package lecture_11_Arrays;

/**
 * Implementation of the linear search algorithm
 */
public class LinearSearch {
    public static void main(String[] args) {
        // Sample array with values
        int[] arr = {2, 3, 4, 5, 6, 7, 7, 9, -4, 7, 11};
        
        int item = 4;
        int index = search(arr, item);
        
        if (index != -1) {
            System.out.println("Item " + item + " found at index: " + index);
        } else {
            System.out.println("Item " + item + " not found in the array.");
        }
    }
    
    /**
     * Performs linear search on an array
     * @param arr the array to search in
     * @param item the element to search for
     * @return the index of the first occurrence of the item, or -1 if not found
     */
    public static int search(int[] arr, int item) {
        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i; // Return the index when item is found
            }
        }
        return -1; // Return -1 if item is not found
    }
}
