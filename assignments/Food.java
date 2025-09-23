package week6.assignments;

abstract class Food {
    // Template method
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    public void wash() {
        System.out.println("Washing ingredients");
    }

    public abstract void cook();

    public void serve() {
        System.out.println("Serving the food");
    }
}

class Pizza extends Food {
    @Override
    public void cook() {
        System.out.println("Baking the pizza in the oven");
    }
}

class Soup extends Food {
    @Override
    public void cook() {
        System.out.println("Simmering the soup on the stove");
    }

    public static void main(String[] args) {
        Food pizza = new Pizza();
        pizza.prepare();

        System.out.println();

        Food soup = new Soup();
        soup.prepare();
    }
}
