package week7.labs;

// Problem5_Streaming.java
class Content {
    String title;
    public Content(String title) { this.title = title; }
}

class Movie extends Content {
    public Movie(String title) { super(title); }
    void movieInfo() { System.out.println("Movie: " + title + " | Duration: 2 hrs | Subtitles available"); }
}

class TVSeries extends Content {
    public TVSeries(String title) { super(title); }
    void seriesInfo() { System.out.println("Series: " + title + " | Next episode suggestion available"); }
}

class Documentary extends Content {
    public Documentary(String title) { super(title); }
    void docInfo() { System.out.println("Documentary: " + title + " | Educational content with related topics"); }
}

public class Problem5_Streaming {
    public static void main(String[] args) {
        Content c1 = new Movie("Inception");
        Content c2 = new TVSeries("Breaking Bad");
        Content c3 = new Documentary("Planet Earth");

        if (c1 instanceof Movie) ((Movie)c1).movieInfo();
        if (c2 instanceof TVSeries) ((TVSeries)c2).seriesInfo();
        if (c3 instanceof Documentary) ((Documentary)c3).docInfo();
    }
}
