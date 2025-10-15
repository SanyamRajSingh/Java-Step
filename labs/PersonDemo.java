package week9.labs;

class Address implements Cloneable {
    String city;
    public Address(String city) { this.city = city; }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name; this.address = address;
    }

    // Shallow clone
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep clone
    public Person deepClone() throws CloneNotSupportedException {
        Address newAddr = (Address) address.clone();
        return new Person(name, newAddr);
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", city=" + address.city + "]";
    }
}

public class PersonDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address a1 = new Address("Chennai");
        Person p1 = new Person("Sam", a1);
        Person p2 = (Person) p1.clone();
        Person p3 = p1.deepClone();

        p2.address.city = "Delhi"; // impacts p1 if shallow
        p3.address.city = "Mumbai"; // does not impact p1

        System.out.println("Original: " + p1);
        System.out.println("Shallow clone: " + p2);
        System.out.println("Deep clone: " + p3);
    }
}
