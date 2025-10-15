package week9.practice_problems;

interface Notifier {
    void send(String message);
}

class Service {
    public void triggerAlert() {
        Notifier notifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("ALERT: " + message);
            }
        };
        notifier.send("Server down!");
    }
}

public class NotificationService {
    public static void main(String[] args) {
        new Service().triggerAlert();
    }
}
