package SwitchStament;
//Problem 3: Grade System
// Create a program that assigns grades based on marks using switch statements. For example, 90–100 is "A", 80–89 is "B", 70–79 is "C", and so on.

// Example

// Input: 85
// Output: B
import java.util.Scanner;

public class GradeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your marks (0-100):");
        int marks = scanner.nextInt();
        
        String grade;
        switch (marks / 10) {
            case 10: case 9:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
                grade = "D";
                break;
            case 5:
                grade = "E";
                break;
            default:
                grade = "F";
        }
        
        System.out.println("Your grade is: " + grade);
    }
}
