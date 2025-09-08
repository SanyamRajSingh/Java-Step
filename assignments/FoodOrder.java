package assignments;

public class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;

    private static final double fixedRate = 150.0;

    // Default constructor
    public FoodOrder() {
        this("Unknown", "Unknown", 0, 0);
    }

    // Constructor with food item (quantity=1, price=fixedRate)
    public FoodOrder(String foodItem) {
        this("Unknown", foodItem, 1, fixedRate);
    }

    // Constructor with food item and quantity (calculate price)
    public FoodOrder(String foodItem, int quantity) {
        this("Unknown", foodItem, quantity, quantity * fixedRate);
    }

    // Full constructor
    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    public void printBill() {
        System.out.println("Customer: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: ₹" + price);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        FoodOrder order1 = new FoodOrder();
        FoodOrder order2 = new FoodOrder("Burger");
        FoodOrder order3 = new FoodOrder("Pizza", 3);
        FoodOrder order4 = new FoodOrder("Alice", "Pasta", 2, 400);

        order1.printBill();
        order2.printBill();
        order3.printBill();
        order4.printBill();
    }
}
