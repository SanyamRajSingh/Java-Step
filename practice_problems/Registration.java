package week9.practice_problems;

class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public Student shallowClone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) contact.clone();
        return cloned;
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo ci = new ContactInfo("test@srm.com", "1099887766");
        Student s1 = new Student("2201", "Rohan", ci);

        Student shallow = s1.shallowClone();
        Student deep = s1.deepClone();

        // Modify contact in shallow clone
        shallow.contact.email = "changed@domain.com";

        System.out.println("Original: " + s1.contact.email);
        System.out.println("Shallow: " + shallow.contact.email);
        System.out.println("Deep: " + deep.contact.email);
    }
}
