package week8.labs;

abstract class Vehicle {
    protected int speed;        // km/h
    protected String fuelType;  // Petrol/Diesel/EV/etc.

    protected Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();

    public void status() {
        System.out.println("Vehicle -> Speed: " + speed + " km/h, Fuel: " + fuelType);
    }
}

interface Maintainable {
    String serviceInfo();
}

class Car extends Vehicle implements Maintainable {
    private boolean engineOn;

    public Car(int speed, String fuelType) {
        super(speed, fuelType);
    }

    @Override
    public void startEngine() {
        if (!engineOn) {
            engineOn = true;
            System.out.println("Car: Engine started.");
        } else {
            System.out.println("Car: Engine already running.");
        }
    }

    @Override
    public String serviceInfo() {
        return "Service every 10,000 km or 12 months, whichever comes first.";
    }

    public void stopEngine() {
        if (engineOn) {
            engineOn = false;
            System.out.println("Car: Engine stopped.");
        } else {
            System.out.println("Car: Engine already off.");
        }
    }
}

public class Lab3Demo {
    public static void main(String[] args) {
        Car car = new Car(0, "Petrol");
        car.status();
        car.startEngine();
        System.out.println("Service Info: " + car.serviceInfo());
        car.stopEngine();
    }
}
