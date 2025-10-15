package week9.labs;

class Car {
    private String brand, model;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", price=" + price + "]";
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 3000000);
        System.out.println(car); // invokes toString
        System.out.println("Class name: " + car.getClass().getName());
    }
}
