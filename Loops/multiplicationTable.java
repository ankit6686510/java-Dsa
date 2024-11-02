import java.util.Scanner;


public class multiplicationTable {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        System.out.print("enter a number");
        int num = scn.nextInt();

        for(int i = 1 ; i <= 10 ; i++){
            System.out.println(num + " * "+ i+ " = " + (num*i));

        }
        scn.close();
    }
}
