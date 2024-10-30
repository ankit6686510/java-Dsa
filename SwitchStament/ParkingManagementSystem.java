package SwitchStament;
// Problem: Parking Management System
// Create a parking management system for a building with 3 levels. Each level has a different parking rate:

// Level 1 (Reserved Parking): ₹100 per hour
// Level 2 (General Parking): ₹50 per hour
// Level 3 (Two-Wheeler Parking): ₹30 per hour
// The program should:

// Prompt the user to select a parking level (1, 2, or 3).
// Ask for the number of hours they plan to park.
// Calculate and display the total parking cost based on the chosen level and hours.
// Allow the user to select "1: Add Hours" or "2: Quit" to either add more hours to the same parking session or quit.

/*flow chart
 * Select Parking Level:
1. Level 1 - Reserved Parking
2. Level 2 - General Parking
3. Level 3 - Two-Wheeler Parking
Enter choice: 2

Enter hours parked: 3
Total cost: ₹150

Would you like to:
1. Add Hours
2. Quit
Enter choice: 1

Enter additional hours: 2
Updated cost: ₹250

Would you like to:
1. Add Hours
2. Quit
Enter choice: 2

Thank you for using the parking management system!

 */

 //code:
 import java.util.Scanner;

public class ParkingManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int level, hours, totalHours = 0;
        int ratePerHour = 0;
        boolean continueSession = true;

        System.out.println("Select Parking Level:");
        System.out.println("1. Level 1 - Reserved Parking (₹100/hr)");
        System.out.println("2. Level 2 - General Parking (₹50/hr)");
        System.out.println("3. Level 3 - Two-Wheeler Parking (₹30/hr)");
        System.out.print("Enter choice: ");
        level = scanner.nextInt();

        switch(level) {
            case 1:
                ratePerHour = 100;
                break;
            case 2:
                ratePerHour = 50;
                break;
            case 3:
                ratePerHour = 30;
                break;
            default:
                System.out.println("Invalid parking level selected.");
                return; // Exit program if invalid level
        }

        while (continueSession) {
            System.out.print("Enter hours parked: ");
            hours = scanner.nextInt();
            totalHours += hours;
            int totalCost = totalHours * ratePerHour;
            System.out.println("Total cost: ₹" + totalCost);

            System.out.println("Would you like to:");
            System.out.println("1. Add Hours");
            System.out.println("2. Quit");
            System.out.print("Enter choice: ");
            int userChoice = scanner.nextInt();

            switch(userChoice) {
                case 1:
                    System.out.print("Enter additional hours: ");
                    hours = scanner.nextInt();
                    totalHours += hours;
                    System.out.println("Updated cost: ₹" + (totalHours * ratePerHour));
                    break;
                case 2:
                    continueSession = false;
                    System.out.println("Thank you for using the parking management system!");
                    break;
                default:
                    System.out.println("Invalid choice, ending session.");
                    continueSession = false;
            }
        }
    }
}
