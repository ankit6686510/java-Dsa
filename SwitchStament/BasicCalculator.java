package SwitchStament;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();
        
        System.out.println("Enter operator (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        
        System.out.println("Enter second number:");
        double num2 = scanner.nextDouble();
        
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            default:
                System.out.println("Invalid operator");
        }
    }
}
// Problem 2: Basic Calculator
// Build a simple calculator that performs basic operations: addition, subtraction, multiplication, and division. Take two numbers and an operator (+, -, *, /) as input. Use a switch statement to perform the operation and display the result.

// Example

// Input: 10, +, 5
// Output: 15