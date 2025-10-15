package week9.practice_problems;

public class AppConfigurator {
    public static void main(String[] args) {
        AppConfig.NetworkConfig nc = new AppConfig.NetworkConfig("192.168.1.1", 8080);
        nc.printDetails();
    }
}
