package week7.labs;

// Problem2_SocialMedia.java
class Post {
    String author, content, time;

    public Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println(author + " posted: " + content + " at " + time);
    }
}

class InstagramPost extends Post {
    int likes;
    public InstagramPost(String author, String content, String time, int likes) {
        super(author, content, time);
        this.likes = likes;
    }
    @Override
    public void display() {
        System.out.println("[Instagram] " + author + " shared: " + content + " ❤️ " + likes + " likes");
    }
}

class TwitterPost extends Post {
    int retweets;
    public TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }
    @Override
    public void display() {
        System.out.println("[Twitter] " + author + ": \"" + content + "\" (" + content.length() + " chars) 🔁 " + retweets + " retweets");
    }
}

class LinkedInPost extends Post {
    int connections;
    public LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }
    @Override
    public void display() {
        System.out.println("[LinkedIn] " + author + " shared a professional update: " + content + " 👥 " + connections + " connections");
    }
}

public class Problem2_SocialMedia {
    public static void main(String[] args) {
        Post insta = new InstagramPost("Alice", "Beautiful sunset!", "10:00 AM", 120);
        Post twitter = new TwitterPost("Bob", "Learning Java Polymorphism!", "11:00 AM", 50);
        Post linkedin = new LinkedInPost("Charlie", "New job opportunity posted!", "12:00 PM", 500);

        insta.display();
        twitter.display();
        linkedin.display();
    }
}
