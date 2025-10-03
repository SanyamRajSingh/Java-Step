package week8.assignment;

interface Printer {
    void connect();
}

interface Scanner {
    void connect();
}

class AllInOneMachine implements Printer, Scanner {
    // One connect() method satisfies both interfaces because the signature matches.
    @Override
    public void connect() {
        System.out.println("AllInOneMachine: Connected as Printer/Scanner.");
    }

    public void print(String doc) {
        System.out.println("Printing: " + doc);
    }

    public void scan(String target) {
        System.out.println("Scanning to: " + target);
    }
}

public class AllInOneDemo {
    public static void main(String[] args) {
        Printer p = new AllInOneMachine();
        p.connect();

        Scanner s = new AllInOneMachine();
        s.connect();

        AllInOneMachine aio = new AllInOneMachine();
        aio.connect();
        aio.print("Report.pdf");
        aio.scan("output.jpg");
    }
}
