package labs;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String evolutionStage;
    private boolean isGhost;
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;
    private static final Random rand = new Random();

    // Main constructor
    public VirtualPet(String petId, String petName, String species, int age, int happiness, int health, String stage, boolean isGhost) {
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStage = stage;
        this.isGhost = isGhost;
        totalPetsCreated++;
    }

    // Constructor chaining
    public VirtualPet() {
        this(generatePetId(), "???", randomSpecies(), 0, 40, 40, EVOLUTION_STAGES[0], false);
    }

    public VirtualPet(String petName) {
        this(generatePetId(), petName, randomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1], false);
    }

    public VirtualPet(String petName, String species) {
        this(generatePetId(), petName, species, 3, 70, 70, EVOLUTION_STAGES[2], false);
    }

    public static String generatePetId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private static String randomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Griffin", "Wolf"};
        return speciesList[rand.nextInt(speciesList.length)];
    }

    public void feedPet() {
        if (isGhost) {
            System.out.println(petName + " is a ghost and doesn't eat!");
            return;
        }
        int healthGain = rand.nextInt(10) + 5;
        int happinessGain = rand.nextInt(10) + 5;
        health = Math.min(100, health + healthGain);
        happiness = Math.min(100, happiness + happinessGain);
        System.out.println(petName + " happily ate some food! +" + healthGain + " health, +" + happinessGain + " happiness.");
    }

    public void playWithPet() {
        if (isGhost) {
            System.out.println(petName + " howls eerily as a ghost. Playtime is spooky!");
            return;
        }
        int happinessGain = rand.nextInt(15) + 5;
        int healthLoss = rand.nextInt(5) + 2;
        happiness = Math.min(100, happiness + happinessGain);
        health = Math.max(0, health - healthLoss);
        System.out.println(petName + " played energetically! +" + happinessGain + " happiness, -" + healthLoss + " health.");
    }

    public void healPet() {
        if (isGhost) {
            System.out.println(petName + " is a ghost. Healing won't bring it back...");
            return;
        }
        int healAmount = rand.nextInt(15) + 10;
        health = Math.min(100, health + healAmount);
        System.out.println(petName + " feels better! +" + healAmount + " health.");
    }

    public void simulateDay() {
        if (isGhost) {
            System.out.println(petName + " floats hauntingly around the pet daycare...");
            return;
        }
        age++;
        happiness = Math.max(0, happiness - rand.nextInt(10));
        health = Math.max(0, health - rand.nextInt(12));
        System.out.println("\nA day passes for " + petName + ": Age " + age + ", Happiness " + happiness + ", Health " + health);
        checkHealth();
        evolvePet();
    }

    private void checkHealth() {
        if (health <= 0) {
            isGhost = true;
            evolutionStage = "Ghost";
            System.out.println("\nSadly, " + petName + " has passed away and become a Ghost!");
        }
    }

    public void evolvePet() {
        if (isGhost) return;

        int stageIndex = indexOfStage(evolutionStage);
        if (age >= (stageIndex + 1) * 3 && stageIndex < EVOLUTION_STAGES.length - 1) {
            evolutionStage = EVOLUTION_STAGES[stageIndex + 1];
            System.out.println(petName + " has evolved to " + evolutionStage + " stage!");
        }
    }

    private int indexOfStage(String stage) {
        for (int i = 0; i < EVOLUTION_STAGES.length; i++) {
            if (EVOLUTION_STAGES[i].equals(stage)) return i;
        }
        return 0;
    }

    public void displayPetInfo() {
        System.out.println("\n--- Pet Info ---");
        System.out.println("ID: " + petId);
        System.out.println("Name: " + petName);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age);
        System.out.println("Happiness: " + happiness);
        System.out.println("Health: " + health);
        System.out.println("Evolution Stage: " + evolutionStage);
        System.out.println("Status: " + (isGhost ? "Ghost" : "Alive"));
    }

    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Virtual Pet Daycare!");
        Scanner scanner = new Scanner(System.in);

        VirtualPet[] pets = new VirtualPet[] {
                new VirtualPet(),
                new VirtualPet("Spark"),
                new VirtualPet("Luna", "Unicorn")
        };

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Simulate Day for all Pets");
            System.out.println("2. Feed a Pet");
            System.out.println("3. Play with a Pet");
            System.out.println("4. Heal a Pet");
            System.out.println("5. Show All Pets Info");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    for (VirtualPet pet : pets) pet.simulateDay();
                    break;
                case 2:
                    VirtualPet petToFeed = choosePet(pets, scanner);
                    if (petToFeed != null) petToFeed.feedPet();
                    break;
                case 3:
                    VirtualPet petToPlay = choosePet(pets, scanner);
                    if (petToPlay != null) petToPlay.playWithPet();
                    break;
                case 4:
                    VirtualPet petToHeal = choosePet(pets, scanner);
                    if (petToHeal != null) petToHeal.healPet();
                    break;
                case 5:
                    for (VirtualPet pet : pets) pet.displayPetInfo();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
        System.out.println("Thanks for playing! Total pets created: " + getTotalPetsCreated());
    }

    private static VirtualPet choosePet(VirtualPet[] pets, Scanner scanner) {
        System.out.println("Choose a pet by number:");
        for (int i = 0; i < pets.length; i++) {
            System.out.println((i + 1) + ". " + pets[i].petName + " (" + pets[i].evolutionStage + ")");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > pets.length) {
            System.out.println("Invalid selection.");
            return null;
        }
        return pets[choice - 1];
    }
}
