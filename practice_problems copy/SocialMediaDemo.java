package week7.practice_problems;

// Base class
class SocialMediaPost {
    protected String content;
    protected String author;

    public SocialMediaPost(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public void share() {
        System.out.println("Sharing content by " + author);
    }
}

// Instagram post subclass
class InstagramPost extends SocialMediaPost {
    private int likes;

    public InstagramPost(String content, String author, int likes) {
        super(content, author);
        this.likes = likes;
    }

    @Override
    public void share() {
        System.out.println("Instagram post: " + content + " by " + author + " - " + likes + " likes");
    }
}

// Twitter post subclass
class TwitterPost extends SocialMediaPost {
    private int retweets;

    public TwitterPost(String content, String author, int retweets) {
        super(content, author);
        this.retweets = retweets;
    }

    @Override
    public void share() {
        System.out.println("Tweet: " + content + " by " + author + " - " + retweets + " retweets");
    }
}

public class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPost[] posts = new SocialMediaPost[3];

        posts[0] = new InstagramPost("Sunset vibes!", "johndoe", 245);
        posts[1] = new TwitterPost("Java is awesome!", "codeninja", 89);
        posts[2] = new SocialMediaPost("Hello world!", "beginner");

        for (SocialMediaPost post : posts) {
            post.share();
        }
    }
}
