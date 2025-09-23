package week7.assignments;

abstract class Vehicle {
    protected String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public abstract void dispatch();
}

class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String id, int passengerCapacity) {
        super(id);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void dispatch() {
        System.out.println("Bus " + id + " dispatched: Route fixed with capacity " + passengerCapacity);
    }
}

class Taxi extends Vehicle {
    private double farePerKm;
    private double distance;

    public Taxi(String id, double farePerKm, double distance) {
        super(id);
        this.farePerKm = farePerKm;
        this.distance = distance;
    }

    @Override
    public void dispatch() {
        System.out.println("Taxi " + id + " dispatched: Fare calculated is " + (farePerKm * distance));
    }
}

class Train extends Vehicle {
    private int carCount;

    public Train(String id, int carCount) {
        super(id);
        this.carCount = carCount;
    }

    @Override
    public void dispatch() {
        System.out.println("Train " + id + " dispatched: " + carCount + " cars on schedule");
    }
}

class Bike extends Vehicle {
    @Override
    public void dispatch() {
        System.out.println("Bike dispatched for short distance eco-friendly trip");
    }

    public Bike(String id) {
        super(id);
    }
}

public class TransportationFleet {
    public static void main(String[] args) {
        Vehicle[] fleet = {
                new Bus("B101", 40),
                new Taxi("T202", 5.5, 12.3),
                new Train("TR303", 8),
                new Bike("BK404")
        };

        for (Vehicle v : fleet) {
            v.dispatch();
        }
    }
}
