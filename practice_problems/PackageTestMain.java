package week5.practice_problems;

import week5.practice_problems.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(7, "differentPackage", 15.0, true);

        System.out.println("Testing access from a different package:");

        // System.out.println(obj.privateField); // Not accessible
        // System.out.println(obj.defaultField); // Not accessible
        // System.out.println(obj.protectedField); // Not accessible (not subclass)
        System.out.println("publicField = " + obj.publicField);

        // obj.privateMethod(); // Not accessible
        // obj.defaultMethod(); // Not accessible
        // obj.protectedMethod(); // Not accessible
        obj.publicMethod();
    }
}
