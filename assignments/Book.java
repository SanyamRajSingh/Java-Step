package assignments;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Default constructor
    public Book() {
        this("", "", "", true);
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this(title, author, "", true);
    }

    // Full constructor
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Clean Code", "Robert Martin");
        Book book3 = new Book("Effective Java", "Joshua Bloch", "978-0134685991", true);

        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();

        book2.borrowBook();
        book3.borrowBook();

        book2.displayBookInfo();
        book3.returnBook();
        book3.displayBookInfo();
    }
}
