package SwitchStament;

/*
 Problem: Library Management System
You need to design a simple library management system where users can:

Add Books: Enter details of a new book, including title, author, and available copies.
Borrow Books: Borrow a book by entering its title.
Return Books: Return a previously borrowed book.
View All Books: Display all books in the library with details.
Quit: Exit the system.
The library can hold up to a fixed number of books (e.g., 50), and each book has a maximum of 5 copies.

Requirements
Option to Add Books: If a book with the same title already exists, prompt the user to update the number of available copies.
Borrow a Book: If the requested book exists and has copies available, decrement the count of available copies; otherwise, show a "Not available" message.
Return a Book: If the user returns a book, increment the count of available copies (up to the maximum limit).
View All Books: List all books, including their titles, authors, and available copies

 */
/*FLOW CHART
 * Library Management System
1. Add Book
2. Borrow Book
3. Return Book
4. View All Books
5. Quit
Enter choice: 1

Enter book title: Java Programming
Enter author name: John Doe
Enter number of copies: 3
Book added successfully!

Would you like to:
1. Add Book
2. Borrow Book
3. Return Book
4. View All Books
5. Quit
Enter choice: 4

Books in the Library:
Title: Java Programming, Author: John Doe, Available Copies: 3

Enter choice: 2
Enter book title to borrow: Java Programming
Book borrowed successfully!

Would you like to:
1. Add Book
2. Borrow Book
3. Return Book
4. View All Books
5. Quit
Enter choice: 5

Thank you for using the library management system!

 */
import java.util.Scanner;

public class LibraryManagementSystem {
    static final int MAX_BOOKS = 50;
    static final int MAX_COPIES = 5;

    static String[] titles = new String[MAX_BOOKS];
    static String[] authors = new String[MAX_BOOKS];
    static int[] copies = new int[MAX_BOOKS];
    static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueSession = true;

        while (continueSession) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    viewBooks();
                    break;
                case 5:
                    continueSession = false;
                    System.out.println("Thank you for using the library management system!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    static void addBook(Scanner scanner) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Library is full, cannot add more books.");
            return;
        }

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter number of copies: ");
        int numCopies = scanner.nextInt();

        if (numCopies > MAX_COPIES) {
            System.out.println("Cannot exceed maximum copies of " + MAX_COPIES);
            return;
        }

        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                copies[i] = Math.min(copies[i] + numCopies, MAX_COPIES);
                System.out.println("Book updated with additional copies.");
                return;
            }
        }

        titles[bookCount] = title;
        authors[bookCount] = author;
        copies[bookCount] = numCopies;
        bookCount++;
        System.out.println("Book added successfully!");
    }

    static void borrowBook(Scanner scanner) {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                if (copies[i] > 0) {
                    copies[i]--;
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Sorry, no copies available.");
                }
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    static void returnBook(Scanner scanner) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                if (copies[i] < MAX_COPIES) {
                    copies[i]++;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("All copies are already in the library.");
                }
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    static void viewBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in the Library:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Title: " + titles[i] + ", Author: " + authors[i] + ", Available Copies: " + copies[i]);
        }
    }
}
