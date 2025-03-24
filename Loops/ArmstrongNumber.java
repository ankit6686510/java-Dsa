import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        System.out.print("enter the number");
        int num =  scn.nextInt();
        int orginalno = num;
        int sum = 0;
        int digit = Integer.toString(num).length();

        while(num != 0){
            int lastDigit = num %10;
            sum += Math.pow(lastDigit , digit);
            num /= 10;

        }
        if(sum == orginalno){
            System.out.println(orginalno +" is an armstrong number");
        }else{
            System.out.println(orginalno +" is not an armstrong number");
        }
        
        // Close scanner to prevent resource leak
        scn.close();
    }
}
/*
 An Armstrong number (also called a narcissistic number) for a given number of digits 𝑛

n is a number that is equal to the sum of its digits each raised to the power of 
𝑛
n. For example:

 */
