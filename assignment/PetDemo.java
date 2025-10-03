package week8.assignment;

interface Animal {
    void eat(String food);
}

interface Pet extends Animal {
    void play(String game);
}

class Dog implements Pet {
    @Override
    public void eat(String food) {
        System.out.println("Dog: Eating " + food);
    }

    @Override
    public void play(String game) {
        System.out.println("Dog: Playing " + game);
    }
}

public class PetDemo {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat("kibble");
        d.play("fetch");
    }
}
