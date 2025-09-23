package week7.labs;

// Problem6_SmartCampus.java
class SmartDevice {
    String name;
    public SmartDevice(String name) { this.name = name; }
}

class SmartClassroom extends SmartDevice {
    public SmartClassroom(String name) { super(name); }
    void control() { System.out.println(name + " controlling lights, AC, and projector."); }
}

class SmartLab extends SmartDevice {
    public SmartLab(String name) { super(name); }
    void manage() { System.out.println(name + " managing equipment and safety systems."); }
}

class SmartLibrary extends SmartDevice {
    public SmartLibrary(String name) { super(name); }
    void track() { System.out.println(name + " tracking occupancy and book availability."); }
}

public class Problem6_SmartCampus {
    public static void main(String[] args) {
        SmartDevice[] devices = {
                new SmartClassroom("Classroom A"),
                new SmartLab("Lab B"),
                new SmartLibrary("Library C")
        };

        for (SmartDevice d : devices) {
            if (d instanceof SmartClassroom) ((SmartClassroom)d).control();
            else if (d instanceof SmartLab) ((SmartLab)d).manage();
            else if (d instanceof SmartLibrary) ((SmartLibrary)d).track();
        }
    }
}
