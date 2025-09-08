package labs;

import java.util.Arrays;
import java.util.Scanner;

abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    public MagicalStructure() {
        this("Unnamed Structure", 0, "Unknown Location", false);
    }

    public MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Unknown Location", false);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();

    @Override
    public String toString() {
        return structureName + " at " + location + " | Magic Power: " + magicPower + " | Active: " + isActive;
    }
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower() {
        this("Basic Wizard Tower", 50, "Tower Hill", false, 5, new String[]{"Fireball", "Shield"});
    }

    public WizardTower(String structureName, int magicPower, int spellCapacity) {
        this(structureName, magicPower, "Tower Hill", true, spellCapacity, new String[]{"Fireball", "Shield"});
    }

    public WizardTower(String structureName, int magicPower, String location, boolean isActive, int spellCapacity, String[] knownSpells) {
        super(structureName, magicPower, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts spells: " + Arrays.toString(knownSpells));
    }

    public int getSpellCapacity() {
        return isActive ? spellCapacity : 0;
    }

    public void doubleSpellCapacity() {
        this.spellCapacity *= 2;
        System.out.println(structureName + "'s spell capacity doubled to " + spellCapacity + "!");
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle() {
        this("Simple Fort", 30, "Castle Grounds", true, 50, false);
    }

    public EnchantedCastle(String name, int power, int defenseRating, boolean hasDrawbridge) {
        this(name, power, "Castle Grounds", true, defenseRating, hasDrawbridge);
    }

    public EnchantedCastle(String structureName, int magicPower, String location, boolean isActive, int defenseRating, boolean hasDrawbridge) {
        super(structureName, magicPower, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a defensive shield with power " + magicPower);
    }

    public int getDefenseRating() {
        return defenseRating;
    }

    public void tripleDefense() {
        this.defenseRating *= 3;
        System.out.println(structureName + "'s defense tripled to " + defenseRating + "!");
    }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary() {
        this("Old Library", 40, "Library District", true, 1000, "Ancient Tongue");
    }

    public MysticLibrary(String name, int power, int bookCount, String language) {
        this(name, power, "Library District", true, bookCount, language);
    }

    public MysticLibrary(String structureName, int magicPower, String location, boolean isActive, int bookCount, String ancientLanguage) {
        super(structureName, magicPower, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " fills the air with ancient knowledge and magic.");
    }

    public int getBookCount() {
        return bookCount;
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair() {
        this("Basic Lair", 60, "Dragon Mountain", true, "Fire Dragon", 1000);
    }

    public DragonLair(String name, int power, String dragonType, int treasureValue) {
        this(name, power, "Dragon Mountain", true, dragonType, treasureValue);
    }

    public DragonLair(String structureName, int magicPower, String location, boolean isActive, String dragonType, int treasureValue) {
        super(structureName, magicPower, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " breathes mighty dragon flames!");
    }
}

class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        if (!s1.isActive || !s2.isActive) return false;

        if ((s1 instanceof WizardTower && s2 instanceof MysticLibrary) ||
                (s1 instanceof MysticLibrary && s2 instanceof WizardTower))
            return true;

        if ((s1 instanceof EnchantedCastle && s2 instanceof DragonLair) ||
                (s1 instanceof DragonLair && s2 instanceof EnchantedCastle))
            return true;

        if (s1.getClass() == s2.getClass() && s1 instanceof WizardTower)
            return true;

        return false;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (!attacker.isActive || !defender.isActive)
            return "Battle cannot proceed because a structure is inactive.";

        if (attacker.magicPower > defender.magicPower)
            return attacker.structureName + " triumphs over " + defender.structureName + " in battle!";
        if (attacker.magicPower < defender.magicPower)
            return defender.structureName + " defends successfully against " + attacker.structureName + ".";
        return "The battle between " + attacker.structureName + " and " + defender.structureName + " ends in a draw.";
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int totalPower = 0;

        for (MagicalStructure s : structures) {
            int basePower = s.magicPower;
            if (s instanceof WizardTower) {
                basePower += ((WizardTower) s).getSpellCapacity();
            } else if (s instanceof EnchantedCastle) {
                basePower += ((EnchantedCastle) s).getDefenseRating();
            } else if (s instanceof MysticLibrary) {
                basePower += ((MysticLibrary) s).getBookCount() / 100;
            }
            totalPower += basePower;
        }
        return totalPower;
    }

    public static void categorizeStructures(MagicalStructure[] structures) {
        int towers = 0, castles = 0, libraries = 0, lairs = 0;

        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) towers++;
            else if (s instanceof EnchantedCastle) castles++;
            else if (s instanceof MysticLibrary) libraries++;
            else if (s instanceof DragonLair) lairs++;
        }

        System.out.println("Kingdom Structure Breakdown:");
        System.out.println("Wizard Towers: " + towers);
        System.out.println("Enchant Castles: " + castles);
        System.out.println("Mystic Libraries: " + libraries);
        System.out.println("Dragon Lairs: " + lairs);
    }

    public static void determineKingdomSpecialization(MagicalStructure[] structures) {
        int magicPower = 0;
        int defensePower = 0;

        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower || s instanceof MysticLibrary) {
                magicPower += s.magicPower;
            } else if (s instanceof EnchantedCastle || s instanceof DragonLair) {
                defensePower += s.magicPower;
            }
        }

        System.out.print("Kingdom Specialization: ");
        if (magicPower > defensePower) System.out.println("Magic-focused");
        else if (defensePower > magicPower) System.out.println("Defense-focused");
        else System.out.println("Balanced");
    }
}

public class MedievalKingdomBuilder {
    public static void main(String[] args) {
        WizardTower tower1 = new WizardTower();
        WizardTower tower2 = new WizardTower("Grand Tower", 70, 10);

        EnchantedCastle castle1 = new EnchantedCastle();
        EnchantedCastle castle2 = new EnchantedCastle("Royal Castle", 60, 70, true);

        MysticLibrary library1 = new MysticLibrary();
        MysticLibrary library2 = new MysticLibrary("Ancient Library", 80, 5000, "Old Runes");

        DragonLair lair1 = new DragonLair();
        DragonLair lair2 = new DragonLair("Dragon's Keep", 90, "Ice Dragon", 3000);

        MagicalStructure[] kingdom = {tower1, tower2, castle1, castle2, library1, library2, lair1, lair2};

        System.out.println("=== Kingdom Overview ===");
        for (MagicalStructure s : kingdom) {
            System.out.println(s);
            s.castMagicSpell();
        }

        System.out.println();
        KingdomManager.categorizeStructures(kingdom);
        KingdomManager.determineKingdomSpecialization(kingdom);

        System.out.println("\nTesting Interactions:");
        System.out.println("Tower & Library: " + KingdomManager.canStructuresInteract(tower1, library1));
        System.out.println("Castle & Lair: " + KingdomManager.canStructuresInteract(castle1, lair1));
        System.out.println("Two Towers: " + KingdomManager.canStructuresInteract(tower1, tower2));

        System.out.println("\nMagic Battles:");
        System.out.println(KingdomManager.performMagicBattle(tower2, castle2));
        System.out.println(KingdomManager.performMagicBattle(lair2, library2));

        System.out.println("\nTotal Kingdom Magic Power: " + KingdomManager.calculateKingdomMagicPower(kingdom));
    }
}
