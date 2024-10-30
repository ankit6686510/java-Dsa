package SwitchStament;
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {

        //question is below
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number (1-7) to find the day of the week:");
        int day = scanner.nextInt();

        switch(day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
//Problem 1: Day of the Week
// Write a program that uses a switch statement to display the name of the day based on an integer input (1 for Monday, 2 for Tuesday, etc.). If the input is outside the range 1–7, display "Invalid day."

// Example

// Input: 3
// Output: Wednesday