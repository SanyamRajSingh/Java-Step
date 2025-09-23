package week7.practice_problems;

public class GameBattle {
    // Basic attack method
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }

    // Overload attack with damage and weapon
    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }

    // Overload attack for critical hits
    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
            attack(damage, weapon);
        }
    }

    // Overload attack for team attacks
    public void attack(int damage, String[] teammates) {
        int teamSize = teammates.length;
        int totalDamage = damage * teamSize;
        System.out.print("Team attack with ");
        for (int i = 0; i < teamSize; i++) {
            System.out.print(teammates[i]);
            if (i < teamSize - 1) System.out.print(", ");
        }
        System.out.println(" for " + totalDamage + " total damage!");
    }

    public static void main(String[] args) {
        GameBattle gb = new GameBattle();

        gb.attack(50); // Basic attack
        gb.attack(75, "Sword"); // Weapon attack
        gb.attack(60, "Bow", true); // Critical hit attack
        gb.attack(40, new String[]{"Alice", "Bob"}); // Team attack
    }
}
