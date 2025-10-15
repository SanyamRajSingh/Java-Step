package week9.practice_problems;

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        System.out.println(v1);

        Vehicle v2 = new Vehicle("MH12AB1234", "Sedan", 1500);
        System.out.println("v1.equals(v2): " + v1.equals(v2));
        System.out.println("v1.hashCode() == v2.hashCode(): " + (v1.hashCode() == v2.hashCode()));
    }
}
