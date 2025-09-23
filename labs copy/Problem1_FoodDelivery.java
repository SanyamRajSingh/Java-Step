package week7.labs;

// Problem1_FoodDelivery.java
class DeliveryCalculator {
    public void calculate(int distance) {
        double cost = distance * 5;
        System.out.println("Basic Delivery: Distance = " + distance + " km, Cost = ₹" + cost);
    }

    public void calculate(int distance, double priorityFee) {
        double cost = distance * 5 + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + " km, Priority Fee = ₹" + priorityFee + ", Cost = ₹" + cost);
    }

    public void calculate(int distance, int orders, double discountPerOrder) {
        double cost = distance * 5 - (orders * discountPerOrder);
        System.out.println("Group Delivery: Distance = " + distance + " km, Orders = " + orders + ", Cost = ₹" + cost);
    }

    public void calculate(int distance, double discountPercentage, double freeLimit) {
        double cost = distance * 5;
        cost = cost - (cost * discountPercentage / 100);
        if (cost > freeLimit) {
            System.out.println("Festival Special: Distance = " + distance + " km, Discount = " + discountPercentage + "%, Cost = ₹" + cost);
        } else {
            System.out.println("Festival Special: Free Delivery! (Cost waived)");
        }
    }
}

public class Problem1_FoodDelivery {
    public static void main(String[] args) {
        DeliveryCalculator calc = new DeliveryCalculator();
        calc.calculate(10);
        calc.calculate(15, 50);
        calc.calculate(20, 3, 10);
        calc.calculate(12, 20, 200);
    }
}
