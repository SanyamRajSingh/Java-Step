package week9.labs;

import java.util.*;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id; this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return id == s.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + "]";
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(10, "Anuj"));
        set.add(new Student(10, "Anuj"));
        set.add(new Student(11, "Riya"));
        for (Student s : set) System.out.println(s);
    }
}
