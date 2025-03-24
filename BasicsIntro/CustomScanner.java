package BasicsIntro;

/**
 * Custom scanner implementation that can be used instead of java.util.Scanner
 * This avoids conflicts with Java's built-in Scanner class
 */
public class CustomScanner {
    // Custom scanner implementation could go here
    // Example method to read input from command line
    public static String readInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
