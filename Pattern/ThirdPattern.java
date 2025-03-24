import java.util.Scanner;

public class ThirdPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = scn.nextInt();
        int row = 1;
        int star = n;

        while (row <= n) {
            int i = 1;
            while (i <= star) {    // Print stars for the current row
                System.out.print("* ");
                i++;
            }
            System.out.println();   // Move to the next line after each row is printed
            row++;
            star--;                 // Decrease the number of stars for the next row
        }
        
        // Close scanner to prevent resource leak
        scn.close();
    }
}
 