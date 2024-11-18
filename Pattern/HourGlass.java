import java.util.Scanner;

public class HourglassVerticalMirror {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = scn.nextInt();

        // Upper half of the hourglass (inverted triangle)
        for (int row = n; row >= 1; row--) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower half of the hourglass (normal triangle)
        for (int row = 2; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
