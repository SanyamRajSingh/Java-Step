package week7.assignments;

class SmartDevice {
    public void turnOn() {
        System.out.println("Device turning on...");
    }
}

class SmartTV extends SmartDevice {
    public void changeChannel(int channel) {
        System.out.println("Changing channel to " + channel);
    }

    public void adjustVolume(int level) {
        System.out.println("Adjusting volume to " + level);
    }

    public void openApp(String appName) {
        System.out.println("Opening app: " + appName);
    }
}

class SmartThermostat extends SmartDevice {
    public void setTemperature(double temperature) {
        System.out.println("Setting temperature to " + temperature + " degrees");
    }

    public void setHumidity(double humidity) {
        System.out.println("Setting humidity to " + humidity + "%");
    }

    public void energySavingMode() {
        System.out.println("Energy saving mode activated");
    }
}

class SmartSecurity extends SmartDevice {
    public void activateAlarm() {
        System.out.println("Alarm activated");
    }

    public void monitorCameras() {
        System.out.println("Monitoring security cameras");
    }

    public void controlAccess(String user) {
        System.out.println("Access granted to " + user);
    }
}

class SmartKitchenAppliance extends SmartDevice {
    public void setCookingTime(int minutes) {
        System.out.println("Setting cooking time to " + minutes + " minutes");
    }

    public void setTemperature(int temperature) {
        System.out.println("Setting cooking temperature to " + temperature + " degrees");
    }

    public void setRecipe(String recipe) {
        System.out.println("Setting recipe to " + recipe);
    }
}

public class SmartHomeAutomation {
    public static void controlDevice(SmartDevice device) {
        device.turnOn();

        if (device instanceof SmartTV tv) {
            tv.changeChannel(5);
            tv.adjustVolume(15);
            tv.openApp("YouTube");
        } else if (device instanceof SmartThermostat thermostat) {
            thermostat.setTemperature(22.5);
            thermostat.setHumidity(40);
            thermostat.energySavingMode();
        } else if (device instanceof SmartSecurity security) {
            security.activateAlarm();
            security.monitorCameras();
            security.controlAccess("John");
        } else if (device instanceof SmartKitchenAppliance kitchen) {
            kitchen.setCookingTime(30);
            kitchen.setTemperature(180);
            kitchen.setRecipe("Lasagna");
        } else {
            System.out.println("Unknown device type. Cannot control.");
        }
    }

    public static void main(String[] args) {
        SmartDevice[] devices = {
                new SmartTV(),
                new SmartThermostat(),
                new SmartSecurity(),
                new SmartKitchenAppliance()
        };

        for (SmartDevice device : devices) {
            controlDevice(device);
            System.out.println();
        }
    }
}
