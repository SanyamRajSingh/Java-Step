package week7.practice_problems;

class SmartDevice {
    public void turnOn() {
        System.out.println("Device turning on...");
    }
}

class Light extends SmartDevice {
    public void adjustBrightness() {
        System.out.println("Adjusting light brightness...");
    }
}

class Thermostat extends SmartDevice {
    public void setTemperature(int temp) {
        System.out.println("Setting temperature to " + temp + " degrees.");
    }
}

public class SmartHome {
    public static void controlDevice(SmartDevice device) {
        device.turnOn();

        if (device instanceof Light) {
            Light light = (Light) device;
            light.adjustBrightness();
        } else if (device instanceof Thermostat) {
            Thermostat thermostat = (Thermostat) device;
            thermostat.setTemperature(22);
        } else {
            System.out.println("Unknown device type.");
        }
    }

    public static void main(String[] args) {
        SmartDevice device1 = new Light();
        SmartDevice device2 = new Thermostat();

        controlDevice(device1);
        controlDevice(device2);
    }
}
