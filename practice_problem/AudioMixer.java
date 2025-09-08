package practice_problem;

public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor using this() chaining
    public AudioMixer() {
        this("StandardMix-8", 8, false);
    }

    // Two-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false);
    }

    // Three-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }

    // Main constructor - all parameters
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        connectedDevices = new String[numberOfChannels];
        deviceCount = 0;
        System.out.println("AudioMixer constructor executed for " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println("  Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        AudioMixer mixer1 = new AudioMixer();
        AudioMixer mixer2 = new AudioMixer("ProSound-16", 16);
        AudioMixer mixer3 = new AudioMixer("BluetoothMix-12", 12, true);
        AudioMixer mixer4 = new AudioMixer("UltraMix-24", 24, true, 140.0);

        mixer1.connectDevice("Microphone");
        mixer1.connectDevice("Guitar");
        mixer2.connectDevice("Keyboard");
        mixer3.connectDevice("Bluetooth Speaker");
        mixer4.connectDevice("Drum Machine");

        mixer1.displayMixerStatus();
        mixer2.displayMixerStatus();
        mixer3.displayMixerStatus();
        mixer4.displayMixerStatus();

        System.out.println("\nConstructor chaining executed in order of called constructors.");
    }
}
