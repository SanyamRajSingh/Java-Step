package week7.assignments;

class Artwork {
    protected String title;

    public Artwork(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println("Artwork: " + title);
    }
}

class Painting extends Artwork {
    private String brushTechnique;
    private String colorPalette;
    private String frameSpec;

    public Painting(String title, String brushTechnique, String colorPalette, String frameSpec) {
        super(title);
        this.brushTechnique = brushTechnique;
        this.colorPalette = colorPalette;
        this.frameSpec = frameSpec;
    }

    public void showDetails() {
        System.out.println("Painting Technique: " + brushTechnique + ", Colors: " + colorPalette + ", Frame: " + frameSpec);
    }
}

class Sculpture extends Artwork {
    private String material;
    private String dimensions;
    private String lighting;

    public Sculpture(String title, String material, String dimensions, String lighting) {
        super(title);
        this.material = material;
        this.dimensions = dimensions;
        this.lighting = lighting;
    }

    public void showDetails() {
        System.out.println("Sculpture Material: " + material + ", Dimensions: " + dimensions + ", Lighting: " + lighting);
    }
}

class DigitalArt extends Artwork {
    private String resolution;
    private String fileFormat;
    private boolean interactive;

    public DigitalArt(String title, String resolution, String fileFormat, boolean interactive) {
        super(title);
        this.resolution = resolution;
        this.fileFormat = fileFormat;
        this.interactive = interactive;
    }

    public void showDetails() {
        System.out.println("Digital Art Resolution: " + resolution + ", Format: " + fileFormat + ", Interactive: " + interactive);
    }
}

class Photography extends Artwork {
    private String cameraSettings;
    private String editingDetails;
    private String printSpec;

    public Photography(String title, String cameraSettings, String editingDetails, String printSpec) {
        super(title);
        this.cameraSettings = cameraSettings;
        this.editingDetails = editingDetails;
        this.printSpec = printSpec;
    }

    public void showDetails() {
        System.out.println("Photography Camera: " + cameraSettings + ", Editing: " + editingDetails + ", Print Spec: " + printSpec);
    }
}

public class ArtGallery {
    public static void main(String[] args) {
        Artwork[] artworks = {
                new Painting("Sunset", "Impasto", "Warm palette", "Gold frame"),
                new Sculpture("The Thinker", "Bronze", "1.8m H x 0.8m W", "Spotlight"),
                new DigitalArt("Virtual Reality", "4K", "mp4", true),
                new Photography("Nature Shot", "ISO 100, f/2.8", "Photoshop", "Glossy print")
        };

        for (Artwork art : artworks) {
            art.display();

            if (art instanceof Painting) {
                ((Painting) art).showDetails();
            } else if (art instanceof Sculpture) {
                ((Sculpture) art).showDetails();
            } else if (art instanceof DigitalArt) {
                ((DigitalArt) art).showDetails();
            } else if (art instanceof Photography) {
                ((Photography) art).showDetails();
            }

            System.out.println();
        }
    }
}
