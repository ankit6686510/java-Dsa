import java.util.Scanner;

public class SymmetricalTriangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = scn.nextInt();

        for (int row = 1; row <= n; row++) {
            // Left half of the triangle (including center space)
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  ");
            }
            for (int star = 1; star <= row; star++) {
                System.out.print("* ");
            }

            // Right half of the triangle
            for (int star = 1; star < row; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // Close scanner to prevent resource leak
        scn.close();
    }
}
