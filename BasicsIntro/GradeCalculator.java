package BasicsIntro;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);

        //taking input for three subjects
        System.out.print("Enter your maths score:");
        int mathScore = scn.nextInt();

        System.out.print("enter your Science score:");
        int ScienceScore = scn.nextInt();

        System.out.print("enter you english marks:");
        int EnglishSCORE = scn.nextInt();

        //calculating average
        
        double averageScore = (mathScore + ScienceScore + EnglishSCORE )/3;

        //deteriminig grade

        String grade;
        if(averageScore >= 90){
            grade = "A";

        }else if(averageScore >= 80){
            grade = "B";

        }else if(averageScore >= 70){
            grade = "C";
        }else if(averageScore >= 60){
            grade = "D";
        }else{
            grade = "F";
        } 

        //Displaying the output
        System.out.println("\nYour average score is :" +averageScore);
        System.out.println("your grade is:" + grade);
            
        //closing the scanner
        scn.close();
        
        
    }
}
