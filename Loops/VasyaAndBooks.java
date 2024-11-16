import java.util.HashSet;
import java.util.Scanner;

public class VasyaAndBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of students
        HashSet<Integer> readBooks = new HashSet<>(); // Set to track read books

        // Read the order of books to be read
        for (int i = 0; i < n; i++) {
            int book = sc.nextInt(); // Current book to read
            readBooks.add(book); // Add book to the set
        }

        // Check if all books can be read in order
        boolean canRead = true;
        int lastBook = 0; // Track last read book

        for (int book : readBooks) {
            if (book < lastBook) {
                canRead = false; // Cannot read in required order
                break;
            }
            lastBook = book; // Update last read book
        }

        System.out.println(canRead ? "YES" : "NO"); // Print result
        sc.close();
    }
}
