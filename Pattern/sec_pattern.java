package Pattern;

import java.util.Scanner;

public class sec_pattern {
    public static void main(String[] args) {
        Scanner scn  =  new Scanner(System.in);
        int n =  scn.nextInt();
        int row= 1;
        int star = 1;
        while(row <= n){
            int i = 1;
            while(i<= star){
                System.out.print("* ");
                i++;
            }
            row++;
            star++;
            System.out.println();
        }
    }
}
