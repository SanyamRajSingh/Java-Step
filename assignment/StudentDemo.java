package week9.assignment;

import java.util.*;

class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo; this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return rollNo == s.rollNo;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(rollNo);
    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name=" + name + "}";
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(1, "Sam"));
        set.add(new Student(1, "Sam")); // same rollNo, treated as duplicate
        set.add(new Student(2, "Rita"));
        for (Student s : set) System.out.println(s);
    }
}
