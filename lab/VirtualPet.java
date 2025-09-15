package week5.lab;

import java.util.Objects;
import java.util.UUID;

public class VirtualPet {
    // Immutable core fields
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    // Controlled mutable state
    private String petName;
    private int age;         // in years
    private int happiness;   // 0 to 100
    private int health;      // 0 to 100

    // Package accessible constants and data
    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Adult", "Elder"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;

    public static final String PET_SYSTEM_VERSION = "2.0";

    // Default species used
    private static final PetSpecies DEFAULT_SPECIES = new PetSpecies(
            "GenericPet", DEFAULT_EVOLUTION_STAGES, 15, "Forest");

    // Constructors with chaining

    // 1. Default constructor: random pet with default species
    public VirtualPet() {
        this(generatePetId(), "Unknown", DEFAULT_SPECIES, 0, 50, 50);
    }

    // 2. Name only
    public VirtualPet(String petName) {
        this(generatePetId(), petName, DEFAULT_SPECIES, 0, 50, 50);
    }

    // 3. Name and species
    public VirtualPet(String petName, PetSpecies species) {
        this(generatePetId(), petName, species, 0, 50, 50);
    }

    // 4. Full constructor
    public VirtualPet(String petId, String petName, PetSpecies species, int age, int happiness, int health) {
        if (petId == null || petId.isEmpty())
            throw new IllegalArgumentException("Pet ID cannot be empty");
        if (petName == null || petName.isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        if (species == null)
            throw new IllegalArgumentException("Species cannot be null");

        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.birthTimestamp = System.currentTimeMillis();
        this.age = age >= 0 ? age : 0;
        this.happiness = validateStat(happiness);
        this.health = validateStat(health);
    }

    // JavaBean Getters and Setters with validation

    public String getPetId() {
        return petId;
    }

    public PetSpecies getSpecies() {
        return species;
    }

    public long getBirthTimestamp() {
        return birthTimestamp;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        if (petName == null || petName.isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        this.petName = petName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age >= 0 ? age : 0;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = validateStat(happiness);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = validateStat(health);
    }

    // Access-controlled methods

    public void feedPet(String foodType) {
        int bonus = calculateFoodBonus(foodType);
        modifyHappiness(bonus);
        modifyHealth(bonus / 2);
        updateEvolutionStage();
        System.out.println(petName + " enjoyed eating " + foodType + "!");
    }

    public void playWithPet(String gameType) {
        int effect = calculateGameEffect(gameType);
        modifyHappiness(effect);
        modifyHealth(effect / 3);
        updateEvolutionStage();
        System.out.println(petName + " had fun playing " + gameType + "!");
    }

    protected int calculateFoodBonus(String foodType) {
        // Simple example calculation
        if (foodType == null) return 0;
        switch (foodType.toLowerCase()) {
            case "fruit": return 10;
            case "meat": return 15;
            case "junk": return -5;
            default: return 5;
        }
    }

    protected int calculateGameEffect(String gameType) {
        if (gameType == null) return 0;
        switch (gameType.toLowerCase()) {
            case "fetch": return 15;
            case "hide": return 10;
            case "chase": return 20;
            default: return 5;
        }
    }

    private void modifyHappiness(int amount) {
        happiness = validateStat(happiness + amount);
    }

    private void modifyHealth(int amount) {
        health = validateStat(health + amount);
    }

    private void updateEvolutionStage() {
        // Placeholder: could update state based on age, happiness, health
    }

    // Package-private method for internal state debugging
    String getInternalState() {
        return "PetID: " + petId + ", Name: " + petName + ", Species: " + species.getSpeciesName() +
                ", Age: " + age + ", Happiness: " + happiness + ", Health: " + health;
    }

    // Private helpers

    private static int validateStat(int stat) {
        if (stat < 0) return 0;
        if (stat > 100) return 100;
        return stat;
    }

    private static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "VirtualPet{" +
                "petId='" + petId + '\'' +
                ", species=" + species.getSpeciesName() +
                ", birthTimestamp=" + birthTimestamp +
                ", petName='" + petName + '\'' +
                ", age=" + age +
                ", happiness=" + happiness +
                ", health=" + health +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualPet)) return false;
        VirtualPet that = (VirtualPet) o;
        return birthTimestamp == that.birthTimestamp &&
                petId.equals(that.petId) &&
                species.equals(that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, species, birthTimestamp);
    }
}
