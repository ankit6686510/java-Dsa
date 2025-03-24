package sorting;

import java.util.Arrays;

/**
 * Implementation of cyclic sort algorithm
 * Cyclic sort is efficient for arrays containing numbers from 1 to N
 */
public class cyclic_sort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        System.out.println("Array before sorting: " + Arrays.toString(arr));
        
        cyclicSort(arr);
        
        System.out.println("Array after cyclic sort: " + Arrays.toString(arr));
    }
    
    /**
     * Sorts an array using cyclic sort algorithm
     * Most efficient for arrays containing values from 1 to N
     * 
     * @param arr the array to be sorted
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // For 1-indexed elements, correct position is (element - 1)
            int correctPosition = arr[i] - 1;
            
            // If element is not at correct position, swap
            if (arr[i] != arr[correctPosition]) {
                swap(arr, i, correctPosition);
            } else {
                // Move to next element if current is at correct position
                i++;
            }
        }
    }
    
    /**
     * Alternate method for handling 1 to N values with potential duplicates
     * 
     * @param arr the array to be sorted
     */
    public static void cyclicSortWithDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // Ensure the value is within valid range and not a duplicate
            int correctPosition = arr[i] - 1;
            if (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[correctPosition]) {
                swap(arr, i, correctPosition);
            } else {
                i++;
            }
        }
    }
    
    /**
     * Swaps two elements in an array
     * @param arr the array containing elements
     * @param first index of first element
     * @param second index of second element
     */
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
