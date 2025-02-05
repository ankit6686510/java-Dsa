//https://hack.codingblocks.com/app/contests/4035/560/problem
import java.util.Scanner;

public class Conversion_Fahrenheit_to_Celsius {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int minf = scn.nextInt();
        int maxf = scn.nextInt();
       int steps = scn.nextInt();

       for(int i = minf; i <= maxf ; i = i + steps){
        int c = (int)((5.0/9)*(i-32));
        System.out.println(i + "\t" + c);

       }

}
}

