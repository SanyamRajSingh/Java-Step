package week7.labs;

// Problem4_Library.java
class LibraryUser {
    String name;
    public LibraryUser(String name) { this.name = name; }
    public void access() { System.out.println(name + " has general library access."); }
}

class Student extends LibraryUser {
    public Student(String name) { super(name); }
    public void access() { System.out.println(name + " can borrow books and access computers."); }
}

class Faculty extends LibraryUser {
    public Faculty(String name) { super(name); }
    public void access() { System.out.println(name + " can reserve books and access research databases."); }
}

class Guest extends LibraryUser {
    public Guest(String name) { super(name); }
    public void access() { System.out.println(name + " can only browse books."); }
}

public class Problem4_Library {
    public static void main(String[] args) {
        LibraryUser u1 = new Student("Alice");
        LibraryUser u2 = new Faculty("Bob");
        LibraryUser u3 = new Guest("Charlie");

        u1.access();
        u2.access();
        u3.access();
    }
}
