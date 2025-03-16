import java.util.Scanner;

public class PalindromeAndSubstring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter to print substring and palindrome");
        String str = scn.nextLine();
        scn.close();

        checkPalindromeAndSubstring(str); // Call the function to check substrings
    }

    public static void checkPalindromeAndSubstring(String str) {
        // Generating all substrings
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) { 
                String sub = str.substring(i, j);

                if (isPalindrome(sub)) {
                    System.out.println(sub); // Print if it is a palindrome
                }
            }
        }
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
