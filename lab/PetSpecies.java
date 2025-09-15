package week5.lab;

import java.util.Arrays;
import java.util.Objects;

public final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan; // in years
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if (speciesName == null || speciesName.isEmpty())
            throw new IllegalArgumentException("Species name cannot be null or empty");
        if (evolutionStages == null || evolutionStages.length == 0)
            throw new IllegalArgumentException("Evolution stages cannot be null or empty");
        if (maxLifespan <= 0)
            throw new IllegalArgumentException("Max lifespan must be positive");
        if (habitat == null || habitat.isEmpty())
            throw new IllegalArgumentException("Habitat cannot be null or empty");

        this.speciesName = speciesName;
        this.evolutionStages = evolutionStages.clone(); // Defensive copy
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String[] getEvolutionStages() {
        return evolutionStages.clone(); // Defensive copy
    }

    public int getMaxLifespan() {
        return maxLifespan;
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return "PetSpecies{" +
                "speciesName='" + speciesName + '\'' +
                ", evolutionStages=" + Arrays.toString(evolutionStages) +
                ", maxLifespan=" + maxLifespan +
                ", habitat='" + habitat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetSpecies)) return false;
        PetSpecies that = (PetSpecies) o;
        return maxLifespan == that.maxLifespan &&
                speciesName.equals(that.speciesName) &&
                Arrays.equals(evolutionStages, that.evolutionStages) &&
                habitat.equals(that.habitat);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(speciesName, maxLifespan, habitat);
        result = 31 * result + Arrays.hashCode(evolutionStages);
        return result;
    }
}
