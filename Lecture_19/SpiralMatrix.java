package Lecture_19;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 }, 
                        { 9, 10, 11, 12 }, 
                        { 13, 14, 15, 16 }, 
                        { 17, 18, 19, 20 } }; // 5×4 matrix

        spiral(arr); // Corrected method name
    }

    public static void spiral(int[][] arr) {
        int minr = 0, maxr = arr.length - 1;   // Row boundaries
        int minc = 0, maxc = arr[0].length - 1; // Column boundaries
        int total_elements = arr.length * arr[0].length; 
        int count = 0;

        while (count < total_elements) {
            // Print top row (left to right)
            for (int i = minc; i <= maxc && count < total_elements; i++) {
                System.out.print(arr[minr][i] + " ");
                count++;
            }
            minr++;  // Move downward

            // Print right column (top to bottom)
            for (int i = minr; i <= maxr && count < total_elements; i++) {
                System.out.print(arr[i][maxc] + " ");
                count++;
            }
            maxc--;  // Move left

            // Print bottom row (right to left)
            for (int i = maxc; i >= minc && count < total_elements; i--) {
                System.out.print(arr[maxr][i] + " ");
                count++;
            }
            maxr--;  // Move up

            // Print left column (bottom to top)
            for (int i = maxr; i >= minr && count < total_elements; i--) {
                System.out.print(arr[i][minc] + " ");
                count++;
            }
            minc++;  // Move right
        }
    }
}
