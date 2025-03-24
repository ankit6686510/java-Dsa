import java.util.Scanner;

public class First_pattern {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the number of rows: ");
    int n = scn.nextInt();
    int row = 1;
    int star = n;
     
    while(row <= n) {
        int i = 1;
        while(i <= star) {
            System.out.print("*");
            i++;
        }
        row++;
        System.out.println();
    }
    
    // Close scanner to prevent resource leak
    scn.close();
  }  
} 