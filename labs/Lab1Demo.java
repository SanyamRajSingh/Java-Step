package week8.labs;

abstract class Fruit {
    protected String color;
    protected String taste;

    protected Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public abstract void showDetails();
}

interface Edible {
    String nutrientsInfo();
}

class Apple extends Fruit implements Edible {
    private final String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    public void showDetails() {
        System.out.println("Apple Details -> Variety: " + variety + ", Color: " + color + ", Taste: " + taste);
    }

    @Override
    public String nutrientsInfo() {
        return "Rich in fiber and vitamin C";
    }
}

public class Lab1Demo {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.showDetails();
        System.out.println("Nutrients: " + a.nutrientsInfo());
    }
}
