package sorting;

/**
 * Implementation of insertion sort algorithm
 */
public class insertion_sort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        System.out.println("Array before sorting:");
        printArray(arr);
        
        insertionSort(arr);
        
        System.out.println("Array after insertion sort:");
        printArray(arr);
    }

    /**
     * Sorts an array using insertion sort algorithm
     * @param arr the array to be sorted
     * 
     * Time Complexity:
     * - Worst case: O(n²) when array is reverse sorted
     * - Best case: O(n) when array is already sorted
     * - Average case: O(n²)
     * 
     * Space Complexity: O(1)
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];  // Element to be inserted in right position
            int j = i - 1;         // Index of the last element in sorted segment
            
            // Move elements greater than current to one position ahead
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];  // Shift element right
                j--;
            }
            
            // Place current element at its correct position
            arr[j + 1] = current;
        }
    }
    
    /**
     * Helper method to print array elements
     * @param arr array to be printed
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
//time complexities 
//worst case O(n2)--> n is the element of array (isme hme descending order m aggr array milgya to)
//best case O(n) --> linear search for sorted array