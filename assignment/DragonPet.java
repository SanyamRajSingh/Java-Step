package week5.assignment;

import week5.lab.VirtualPet;
import week5.lab.PetSpecies; // make sure PetSpecies exists (enum/class)

public class DragonPet {
    private final VirtualPet virtualPet; // Composition
    private final String dragonType;
    private final String breathWeapon;

    public DragonPet(String petName, PetSpecies species, String dragonType, String breathWeapon) {
        this.virtualPet = new VirtualPet(petName, species);
        this.dragonType = (dragonType != null && !dragonType.isEmpty()) ? dragonType : "Fire";
        this.breathWeapon = (breathWeapon != null && !breathWeapon.isEmpty()) ? breathWeapon : "Flame";
    }

    // JavaBean style getters
    public VirtualPet getVirtualPet() {
        return virtualPet;
    }

    public String getDragonType() {
        return dragonType;
    }

    public String getBreathWeapon() {
        return breathWeapon;
    }

    // Delegate behaviors to VirtualPet
    public void feedPet(String food) {
        virtualPet.feedPet(food);
    }

    public void playWithPet(String game) {
        virtualPet.playWithPet(game);
    }

    @Override
    public String toString() {
        return "DragonPet{" +
                "virtualPet=" + virtualPet +
                ", dragonType='" + dragonType + '\'' +
                ", breathWeapon='" + breathWeapon + '\'' +
                '}';
    }
}
