import java.util.Scanner;

public class pattern_19 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of rows (odd number): ");
        int n = scn.nextInt();
        int row = 1;
        int star = n / 2 + 1;
        int space = -1;
        while (row <= n) {
            // star
            int i = 1;
            while (i <= star) {
                System.out.print("* ");
                i++;
            }
            // space
            int j = 1;
            while (j <= space) {
                System.out.print(" ");
                j++;
            }
            // star
            int k = 1;
            if(row ==1 || row == n){
                k=2;
            }
            while (k <= star) {
                System.out.print("* ");
                k++;
            }
            // next row prep
            if (row <= n / 2) {
                star--;
                space += 2;
            } else {
                star++;
                space -= 2;
            }
            row++; // Move row increment inside the loop
            System.out.println(); // Move to the next line after each row
        }
        
        // Close scanner to prevent resource leak
        scn.close();
    }
}
