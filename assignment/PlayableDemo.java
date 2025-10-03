package week8.assignment;

interface Playable {
    void play();
    void pause();
}

class MusicPlayer implements Playable {
    private boolean playing;

    @Override
    public void play() {
        playing = true;
        System.out.println("MusicPlayer: Playing track...");
    }

    @Override
    public void pause() {
        playing = false;
        System.out.println("MusicPlayer: Paused.");
    }
}

class VideoPlayer implements Playable {
    private boolean playing;

    @Override
    public void play() {
        playing = true;
        System.out.println("VideoPlayer: Playing video...");
    }

    @Override
    public void pause() {
        playing = false;
        System.out.println("VideoPlayer: Paused.");
    }
}

public class PlayableDemo {
    public static void main(String[] args) {
        Playable p1 = new MusicPlayer();
        p1.play();
        p1.pause();

        System.out.println();

        Playable p2 = new VideoPlayer();
        p2.play();
        p2.pause();
    }
}
