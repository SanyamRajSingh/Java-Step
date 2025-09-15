package week5.lab;

public class RobotPet {
    private final VirtualPet virtualPet; // Composition
    private boolean needsCharging;
    private int batteryLevel; // 0 - 100

    public RobotPet(String petName, PetSpecies species) {
        this.virtualPet = new VirtualPet(petName, species);
        this.needsCharging = false;
        this.batteryLevel = 100;
    }

    // JavaBean style

    public VirtualPet getVirtualPet() {
        return virtualPet;
    }

    public boolean isNeedsCharging() {
        return needsCharging;
    }

    public void setNeedsCharging(boolean needsCharging) {
        this.needsCharging = needsCharging;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0) batteryLevel = 0;
        if (batteryLevel > 100) batteryLevel = 100;
        this.batteryLevel = batteryLevel;
    }

    public void chargeBattery() {
        batteryLevel = 100;
        needsCharging = false;
        System.out.println("RobotPet charged to full battery.");
    }

    public void feedPet(String food) {
        virtualPet.feedPet(food);
    }

    public void playWithPet(String game) {
        virtualPet.playWithPet(game);
        batteryLevel -= 10;
        if (batteryLevel <= 20) {
            needsCharging = true;
            System.out.println("Battery low! Need charging soon.");
        }
    }

    @Override
    public String toString() {
        return "RobotPet{" +
                "virtualPet=" + virtualPet +
                ", needsCharging=" + needsCharging +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
