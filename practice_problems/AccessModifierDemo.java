package week5.practice_problems;

public class AccessModifierDemo {
    private int privateField;
    String defaultField; // package-private
    protected double protectedField;
    public boolean publicField;

    // Constructor
    public AccessModifierDemo(int pvt, String def, double prot, boolean pub) {
        this.privateField = pvt;
        this.defaultField = def;
        this.protectedField = prot;
        this.publicField = pub;
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public void testInternalAccess() {
        System.out.println("Testing access inside the same class:");
        System.out.println("privateField = " + privateField);
        System.out.println("defaultField = " + defaultField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField = " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "defaultValue", 20.5, true);

        System.out.println("Accessing from main method:");
        // System.out.println(obj.privateField); // Not accessible directly
        System.out.println("defaultField = " + obj.defaultField);
        System.out.println("protectedField = " + obj.protectedField);
        System.out.println("publicField = " + obj.publicField);

        // obj.privateMethod(); // Not accessible directly
        obj.defaultMethod();
        obj.protectedMethod();
        obj.publicMethod();

        obj.testInternalAccess();
    }
}
