import java.util.Scanner;
public class factorialCal {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        System.out.print("enter a number");
        int n = scn.nextInt();
        int factorial = 1;

        for(int i = 1 ;i <= n; i++){
            factorial *= i;
        }
        System.out.println("factoial of " + n + "is " + factorial);
        
        // Close scanner to prevent resource leak
        scn.close();
    }
}
