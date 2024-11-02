import java.util.Scanner;
public class reversingNumber {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        System.out.print("enter a number");
        int num = scn.nextInt();
        int reversed = 0;

        while(num!= 0 ){
            int lastdigit = num % 10;
            reversed = reversed * 10 + lastdigit;
            num /= 10;
        }
        System.out.println("reversed number: " + reversed);
    }

    
}
