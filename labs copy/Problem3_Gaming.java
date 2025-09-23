package week7.labs;

// Problem3_Gaming.java
abstract class Character {
    abstract void attack();
}

class Warrior extends Character {
    @Override
    void attack() {
        System.out.println("Warrior attacks with sword and strong defense!");
    }
}

class Mage extends Character {
    @Override
    void attack() {
        System.out.println("Mage casts a powerful fireball using mana!");
    }
}

class Archer extends Character {
    @Override
    void attack() {
        System.out.println("Archer shoots arrows from long range!");
    }
}

public class Problem3_Gaming {
    public static void main(String[] args) {
        Character[] army = { new Warrior(), new Mage(), new Archer() };
        for (Character c : army) {
            c.attack();
        }
    }
}
