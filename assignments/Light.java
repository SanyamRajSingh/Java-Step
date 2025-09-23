package week6.assignments;

class Light {
    private int watts;
    private String color;

    public Light() {
        this(60);
        System.out.println("Light default constructor called");
    }

    public Light(int watts) {
        this(watts, "White");
        System.out.println("Light constructor with watts: " + watts);
    }

    public Light(int watts, String color) {
        this.watts = watts;
        this.color = color;
        System.out.println("Light constructor with watts and color: " + watts + ", " + color);
    }
}

class LED extends Light {
    private int brightness;

    public LED() {
        super();
        System.out.println("LED default constructor called");
    }

    public LED(int watts) {
        super(watts);
        System.out.println("LED constructor with watts");
    }

    public LED(int watts, String color) {
        super(watts, color);
        System.out.println("LED constructor with watts and color");
    }

    public LED(int watts, String color, int brightness) {
        this(watts, color);
        this.brightness = brightness;
        System.out.println("LED constructor with brightness: " + brightness);
    }

    public static void main(String[] args) {
        LED led1 = new LED();
        System.out.println("---");
        LED led2 = new LED(9);
        System.out.println("---");
        LED led3 = new LED(12, "Warm White");
        System.out.println("---");
        LED led4 = new LED(15, "Cool White", 1000);
    }
}
