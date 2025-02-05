import java.util.Scanner;

public class chardemo{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char ch =  scn.next().charAt(0);//input

        char ch2 =  'a';
        char ch1 = 'b';    
        System.out.println(ch2); 
        System.out.println(ch1);
        System.out.println((int)(ch));
        System.out.println((int)(ch1));
        System.out.println(ch+ch1);
        
}
}