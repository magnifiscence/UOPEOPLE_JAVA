package LibrarySystem;

public class Book {
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Getters for title, author, and quantity
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters for updating the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Add more books to the quantity
    public void addBooks(int amount) {
        this.quantity += amount;
    }

    // Borrow books if available
    public boolean borrowBooks(int amount) {
        if (amount <= this.quantity) {
            this.quantity -= amount;
            return true;
        }
        return false;
    }

    // Return books and increase quantity
    public void returnBooks(int amount) {
        this.quantity += amount;
    }
}