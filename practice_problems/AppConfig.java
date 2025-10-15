package week9.practice_problems;

public class AppConfig {
    private String appName;

    public AppConfig(String appName) {
        this.appName = appName;
    }

    public static class NetworkConfig {
        private String host;
        private int port;

        public NetworkConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public void printDetails() {
            System.out.println("NetworkConfig: host=" + host + ", port=" + port);
        }
    }
}
