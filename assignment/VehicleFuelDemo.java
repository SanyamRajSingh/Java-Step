package week8.assignment;

abstract class Vehicle {
    public abstract void start();

    public void stop() {
        System.out.println("Vehicle: Stopped.");
    }
}

interface Fuel {
    void refuel(double liters);
}

class Car extends Vehicle implements Fuel {
    private double fuelLevel = 0.0;

    @Override
    public void start() {
        if (fuelLevel > 0) {
            System.out.println("Car: Engine started.");
        } else {
            System.out.println("Car: Cannot start, no fuel.");
        }
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Car: Invalid refuel amount.");
            return;
        }
        fuelLevel += liters;
        System.out.println("Car: Refueled " + liters + " liters. Fuel level = " + fuelLevel);
    }
}

public class VehicleFuelDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.refuel(15);
        car.start();
        car.stop();
    }
}
