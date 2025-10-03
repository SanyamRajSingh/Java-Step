package week8.labs;

abstract class Device {
    protected String brand;
    protected String model;

    protected Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract void powerOn();

    public void info() {
        System.out.println("Device -> Brand: " + brand + ", Model: " + model);
    }
}

interface Connectable {
    void connect(String target);
}

class Smartphone extends Device implements Connectable {
    private boolean powered;

    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void powerOn() {
        if (!powered) {
            powered = true;
            System.out.println("Smartphone: Powered on.");
        } else {
            System.out.println("Smartphone: Already on.");
        }
    }

    @Override
    public void connect(String target) {
        if (!powered) {
            System.out.println("Smartphone: Please power on before connecting.");
            return;
        }
        System.out.println("Smartphone: Connected to " + target + ".");
    }
}

public class Lab6Demo {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("OnePlus", "12R");
        phone.info();
        phone.powerOn();
        phone.connect("Wi-Fi");
    }
}
