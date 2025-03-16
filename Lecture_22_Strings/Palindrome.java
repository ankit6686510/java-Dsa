import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter something to check palindrome: ");
        String str =  scn.next();
        // String str = scn.nextLine();
        scn.close();
        System.out.println(isPalindrome(str));

    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

}
