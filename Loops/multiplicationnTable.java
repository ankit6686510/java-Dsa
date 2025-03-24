import java.util.Scanner;

public class multiplicationnTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " × " + i + " = " + (n * i));
        }
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}
