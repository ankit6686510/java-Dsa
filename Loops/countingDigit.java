import java.util.Scanner;
public class countingDigit {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("enter a number: ");
        int num = scn.nextInt();
        int count = 0;

        while(num != 0) {
            num /= 10;
            count++;
        }
        System.out.println("number of digit: " + count);
        
        // Close scanner to prevent resource leak
        scn.close();
    }
    
}
