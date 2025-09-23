package week6.labs;

class Phone {
    protected String brand;
    protected String model;

    public Phone() {
        System.out.println("Phone default constructor called");
    }

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone parameterized constructor called");
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone() {
        super();
        System.out.println("SmartPhone default constructor called");
    }

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone parameterized constructor called");
    }

    public void showInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", OS: " + operatingSystem);
    }

    public static void main(String[] args) {
        SmartPhone sp1 = new SmartPhone();
        SmartPhone sp2 = new SmartPhone("Apple", "iPhone 14", "iOS");
        sp2.showInfo();
    }
}
