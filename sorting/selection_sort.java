package sorting;

/**
 * Implementation of selection sort algorithm
 */
public class selection_sort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        System.out.println("Array before sorting:");
        printArray(arr);
        
        selectionSort(arr);
        
        System.out.println("Array after selection sort:");
        printArray(arr);
    }

    /**
     * Sorts an array using selection sort algorithm
     * @param arr the array to be sorted
     * 
     * Time Complexity: O(n²) for all cases
     * Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the element at index i
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }
    
    /**
     * Swaps two elements in an array
     * @param arr the array containing elements
     * @param i index of first element
     * @param j index of second element
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
