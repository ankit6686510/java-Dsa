import java.util.Scanner;

public class countdigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        
        System.out.println("Number of digits: " + count);
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}
