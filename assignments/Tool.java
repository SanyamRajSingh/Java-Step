package week6.assignments;

class Tool {
    private String modelNumber = "TN123";
    protected String type = "HammerType";
    public String brand = "ToolBrand";

    public String getModelNumber() {
        return modelNumber;
    }
}

class Hammer extends Tool {
    public void printDetails() {
        // System.out.println("Model Number: " + modelNumber); // Not accessible (private)
        System.out.println("Type: " + type); // Accessible (protected)
        System.out.println("Brand: " + brand); // Accessible (public)
        System.out.println("Model Number (via getter): " + getModelNumber()); // Accessible via getter
    }

    public static void main(String[] args) {
        Hammer hammer = new Hammer();
        hammer.printDetails();
    }
}
