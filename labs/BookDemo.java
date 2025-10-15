package week9.labs;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // reference equality
        if (obj == null || getClass() != obj.getClass()) return false;
        Book b = (Book) obj;
        return title.equals(b.title) && author.equals(b.author);
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java OOP", "Smith");
        Book b2 = new Book("Java OOP", "Smith");
        System.out.println("b1 == b2: " + (b1 == b2)); // reference comparison
        System.out.println("b1.equals(b2): " + b1.equals(b2)); // content comparison
    }
}
