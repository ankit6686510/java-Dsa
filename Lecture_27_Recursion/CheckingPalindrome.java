public class CheckingPalindrome {
    public static void main(String[] args) {
        String str = "malayalam"; // Correct spelling
        char[] ch = str.toCharArray(); // Convert string to char array
        boolean result = isPalindrome(ch, 0, ch.length - 1);
        
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }

    public static boolean isPalindrome(char[] ch, int s, int e) {
        // Base case: if start index crosses end index, it's a palindrome
        if (s >= e) {
            return true;
        }

        // If characters at both ends do not match, it's not a palindrome
        if (ch[s] != ch[e]) {
            return false;
        }

        // Recursive call to check the remaining substring
        return isPalindrome(ch, s + 1, e - 1);
    }
}
