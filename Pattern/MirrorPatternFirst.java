package Pattern;

import java.util.Scanner;

public class MirrorPatternFirst {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // Number of rows for the upper part of the pattern
        int row = 1;
        int star = n;      // Number of stars in the first row
        int space = n - 1; // Space before stars
        

        while (row <= 2 * n - 1) {
            // Print spaces
            int i = 1;
            while (i <= space) {
                System.out.print(" ");
                i++;
            }  

            // Print stars
            int j = 1;
            while (j <= star) {
                System.out.print("* ");
                j++;
            }


            // Adjust `space` and `star` for the next row
            if (row < n) {
                star--;
                space--; // Spaces decrease in the first half
                  
            } else {
                star++;
                space++; // Spaces increase in the second half
                  
            }

            row++;
            System.out.println();
        }
        scn.close();
    }
}
