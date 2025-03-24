import java.util.Scanner;
public class Fibonacci {

    public static void main(String[] args) {    
        Scanner scn =  new Scanner(System.in);
        System.out.print("enter a number");
        int n = scn.nextInt();

        int first = 0, second = 1;
        System.out.println("fibonaaci sequence " + first+" "+ second);
        for(int i = 3; i<=n; i++){
            int next =  first + second;
            System.out.println(next + "");
            first  =  second;
            second =  next;
        }
        // int num = scn.nextInt();
        // int a = 0;
        // int b = 1;
        // int c = 0;
        // System.out.print(a + " " + b + " ");
        // for(int i = 2; i < num; i++) {
        //     c = a + b;
        //     System.out.print(c + " ");
        //     a = b;
        //     b = c;
        // }
        
        // Close scanner to prevent resource leak
        scn.close();
    }
    
}
