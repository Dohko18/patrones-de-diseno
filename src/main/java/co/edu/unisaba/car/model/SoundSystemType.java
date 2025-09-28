package co.edu.unisaba.car.model;

public enum SoundSystemType {

    BASICO("Pioneer","AVH-Z9",false, false),
    PREMIUM("Sony", "XAV-AX6",true, false),
    SURROUND("Kenwood", "DDX990", true, true);

    private final String brand;
    private final String model;
    private final boolean bluetoothEnabled;
    private final boolean touchScreenEnabled;

    SoundSystemType(String brand, String model, boolean bluetoothEnabled, boolean touchScreenEnabled) {
        this.brand = brand;
        this.model = model;
        this.bluetoothEnabled = bluetoothEnabled;
        this.touchScreenEnabled = touchScreenEnabled;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isBluetoothEnabled() {
        return bluetoothEnabled;
    }

    public boolean isTouchScreenEnabled() {
        return touchScreenEnabled;
    }
}
