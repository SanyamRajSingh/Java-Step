package week6.labs;

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin cannot fly");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle is soaring high");
    }
}

public class BirdTest {
    public static void main(String[] args) {
        Bird[] birds = {new Bird(), new Penguin(), new Eagle()};

        for (Bird b : birds) {
            b.fly();
        }
    }
}
