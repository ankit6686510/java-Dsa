import java.util.Scanner ;
public class inputoutput {
    public static void main(String[] args) {
           
        Scanner scn  =  new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scn.nextLine();
        System.out.println("Enter your age: ");
        int age = scn.nextInt();
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.print(name + " is a Awesome Programmer");

        scn.close();

    }
    
}
