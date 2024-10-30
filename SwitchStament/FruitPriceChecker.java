package SwitchStament;
// Problem 4: Fruit Price Checker
// Write a program where each case in the switch statement corresponds to a fruit (like Apple, Banana, etc.), and displays its price per kilogram.

// Example

// Input: Apple
// Output: 100 rupees per kg
import java.util.Scanner;

public class FruitPriceChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a fruit name (Apple, Banana, Mango, Orange):");
        String fruit = scanner.nextLine();
        
        switch (fruit.toLowerCase()) {
            case "apple":
                System.out.println("100 rupees per kg");
                break;
            case "banana":
                System.out.println("40 rupees per dozen");
                break;
            case "mango":
                System.out.println("80 rupees per kg");
                break;
            case "orange":
                System.out.println("60 rupees per kg");
                break;
            default:
                System.out.println("Fruit not available");
        }
    }
}
