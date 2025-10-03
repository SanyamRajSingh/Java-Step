package week8.labs;

abstract class Animal {
    protected String name;
    protected String habitat;

    protected Animal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public abstract void eat();
}

interface Soundable {
    void makeSound();
}

class Dog extends Animal implements Soundable {
    public Dog(String name, String habitat) {
        super(name, habitat);
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating dog food in " + habitat + ".");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

public class Lab5Demo {
    public static void main(String[] args) {
        Dog d = new Dog("Bruno", "Home");
        d.eat();
        d.makeSound();
    }
}
