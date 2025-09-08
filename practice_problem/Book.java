package practice_problem;

public class Book {
    String title;
    String author;
    double price;

    // Default constructor
    public Book() {
        title = "Generic Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display method
    public void display() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println();
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java Programming", "Jane Doe", 299.99);

        book1.display();
        book2.display();
    }
}
