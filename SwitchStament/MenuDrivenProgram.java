package SwitchStament;
// Problem 5: Menu-Driven Program
// Make a menu-driven program where the user selects an option from a list, like "1: Display Date," "2: Greet Me," "3: Quit," and performs actions accordingly.

// Example

// Input: 2
// Output: Hello!

import java.util.Scanner;

public class MenuDrivenProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Menu:");
        System.out.println("1: Display Date");
        System.out.println("2: Greet Me");
        System.out.println("3: Quit");
        
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("Today's date is: " + new java.util.Date());
                break;
            case 2:
                scanner.nextLine(); // Clear buffer
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Hello, " + name + "!");
                break;
            case 3:
                System.out.println("Quitting the program...");
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}
