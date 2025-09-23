package week6.labs;

class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public void showInfo() {
        System.out.println("Color: " + color + ", Taste: " + taste);
    }
}

class Apple extends Fruit {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Variety: " + variety);
    }

    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Fuji");
        apple.showInfo();
    }
}
