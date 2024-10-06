package LibrarySystem;

// File: LibrarySystem.java
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<Book> books;
    private Scanner scanner;

    public LibrarySystem() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    // Add books to the library
    private void addBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.addBooks(quantity);
                System.out.println("Updated the quantity of " + title);
                return;
            }
        }

        books.add(new Book(title, author, quantity));
        System.out.println("Added new book: " + title);
    }

    // Borrow books from the library
    private void borrowBooks() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to borrow: ");
        int quantity = scanner.nextInt();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.borrowBooks(quantity)) {
                    System.out.println("You borrowed " + quantity + " copy/copies of " + title);
                } else {
                    System.out.println("Not enough copies available.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return books to the library
    private void returnBooks() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to return: ");
        int quantity = scanner.nextInt();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBooks(quantity);
                System.out.println("You returned " + quantity + " copy/copies of " + title);
                return;
            }
        }

        System.out.println("This book does not belong to our library.");
    }
}
