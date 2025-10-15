package week9.assignment;

import java.util.*;

class Book implements Cloneable {
    String title;
    Book(String title) { this.title = title; }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        return new Book(title);
    }
}

class Library implements Cloneable {
    List<Book> books;
    Library(List<Book> books) { this.books = books; }

    // Shallow clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // books list reference is shared
    }

    // Deep clone
    public Library deepClone() throws CloneNotSupportedException {
        List<Book> newBooks = new ArrayList<>();
        for (Book b : books) newBooks.add(b.clone());
        return new Library(newBooks);
    }
}

public class LibraryDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java"));
        books.add(new Book("Python"));
        Library lib1 = new Library(books);

        Library shallow = (Library) lib1.clone();
        Library deep = lib1.deepClone();

        shallow.books.get(0).title = "C++";
        deep.books.get(1).title = "AI";

        System.out.println("Original Library: ");
        for (Book b : lib1.books) System.out.println(b.title); // "C++" and "Python"
        System.out.println("Deep Cloned Library: ");
        for (Book b : deep.books) System.out.println(b.title); // "Java" and "AI"
    }
}
