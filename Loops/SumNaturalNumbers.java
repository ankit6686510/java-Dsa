import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        System.out.print("enter a number");
        int N = scn.nextInt();
        int sum = 0 ;

        for(int i = 1 ; i<=N ; i++){
            sum += i; //add i in each iteration
        }
        System.out.println("sum of first" + N + "natural no is " + sum );
        scn.close();
    }
}
// Explanation:
// sum starts from 0, and each i from 1 to N is added to it in the loop.
// The final result gives the sum of numbers from 1 to N.