import java.util.Scanner;

/**
 * This class prints a diamond pattern of stars
 * Example for n=5:
 *         *
 *       * * *
 *     * * * * *
 *   * * * * * * *
 * * * * * * * * * *
 *   * * * * * * *
 *     * * * * *
 *       * * *
 *         *
 */
public class diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows for half diamond: ");
        int n = scanner.nextInt();
        
        printDiamondPattern(n);
        
        scanner.close();
    }
    
    /**
     * Prints a diamond pattern with the specified number of rows
     * 
     * @param rows the number of rows for the upper half of the diamond
     */
    public static void printDiamondPattern(int rows) {
        // Upper half of the diamond
        for (int row = 1; row <= rows; row++) {
            // Print spaces
            for (int space = 1; space <= rows - row; space++) {
                System.out.print("  ");
            }
            
            // Print stars
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("* ");
            }
            
            System.out.println();
        }

        // Lower half of the diamond (excluding the middle row)
        for (int row = rows - 1; row >= 1; row--) {
            // Print spaces
            for (int space = 1; space <= rows - row; space++) {
                System.out.print("  ");
            }
            
            // Print stars
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("* ");
            }
            
            System.out.println();
        }
    }
}
