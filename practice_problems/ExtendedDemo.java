package week5.practice_problems;

public class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int pvt, String def, double prot, boolean pub) {
        super(pvt, def, prot, pub);
    }

    public void testInheritedAccess() {
        System.out.println("Testing inherited access in subclass:");

        // Cannot access privateField or defaultField here
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField = " + publicField);

        // Cannot call privateMethod or defaultMethod here
        protectedMethod();
        publicMethod();
    }

    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protectedMethod in ExtendedDemo");
    }

    public static void main(String[] args) {
        ExtendedDemo obj = new ExtendedDemo(1, "inherited", 3.3, true);

        obj.testInheritedAccess();

        AccessModifierDemo parent = new AccessModifierDemo(2, "parent", 4.4, false);

        parent.protectedMethod();
        obj.protectedMethod();
    }
}
