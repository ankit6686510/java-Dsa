import java.util.Scanner;

public class fourth_Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        int row = 1;
        int star = 1;
        int space = n-1;
        while(row <= n){
            //space
            int i = 1;
            while(i<= space){
                System.out.print("  ");
                i++;

            }
            //star
            int j = 1;
            while(j<= star){
                System.out.print("* ");
                j++;
            }
            row++;
            System.out.println();
            space--;
            star++; 
        }
        
        // Close scanner to prevent resource leak
        sc.close();
    }
}
