package week6.labs;

class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void play() {
        System.out.println("Playing the instrument");
    }
}

class Piano extends Instrument {
    private int keys;

    public Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }

    @Override
    public void play() {
        System.out.println("Playing the piano with " + keys + " keys");
    }
}

class Guitar extends Instrument {
    private int strings;

    public Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }

    @Override
    public void play() {
        System.out.println("Strumming the guitar with " + strings + " strings");
    }
}

class Drum extends Instrument {
    private String drumType;

    public Drum(String name, String material, String drumType) {
        super(name, material);
        this.drumType = drumType;
    }

    @Override
    public void play() {
        System.out.println("Beating the " + drumType + " drum");
    }
}

public class InstrumentTest {
    public static void main(String[] args) {
        Instrument[] instruments = {
                new Piano("Grand Piano", "Wood", 88),
                new Guitar("Acoustic Guitar", "Wood", 6),
                new Drum("Bass Drum", "Metal", "Bass")
        };

        for (Instrument instr : instruments) {
            instr.play();
        }
    }
}
