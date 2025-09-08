package assignments;

public class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;

    // 1. Default constructor
    public MovieTicket() {
        this("Unknown", "Unknown", 0, 0);
    }

    // 2. Constructor with movie name only, default price=200
    public MovieTicket(String movieName) {
        this(movieName, "Unknown", 0, 200);
    }

    // 3. Constructor with movie name and seat number, default theatre=PVR
    public MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200);
    }

    // 4. Full constructor
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void printTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket();
        MovieTicket ticket2 = new MovieTicket("Avengers");
        MovieTicket ticket3 = new MovieTicket("Spider-Man", 15);
        MovieTicket ticket4 = new MovieTicket("Inception", "IMAX", 25, 350);

        ticket1.printTicket();
        ticket2.printTicket();
        ticket3.printTicket();
        ticket4.printTicket();
    }
}
