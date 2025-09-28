package co.edu.unisaba.car;

import co.edu.unisaba.car.model.SoundSystemType;

/**
 * @author Ing. Darwin Esneider Rodriguez Ladino
 * @version Id: <b>task-first</b> 26/09/2025, 9:29 p. m.
 * @email daroxx47@hotmail.com
 **/
public class SoundSystem {
    private final String brand;
    private final String model;
    private final boolean bluetoothEnabled;
    private final boolean touchScreenEnabled;

    public SoundSystem(SoundSystemType soundSystemType) {
        this.brand = soundSystemType.getBrand();
        this.model = soundSystemType.getModel();
        this.bluetoothEnabled = soundSystemType.isBluetoothEnabled();
        this.touchScreenEnabled = soundSystemType.isTouchScreenEnabled();
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

    @Override
    public String toString() {
        return "SoundSystem{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", bluetoothEnabled=" + bluetoothEnabled +
                ", touchScreenEnabled=" + touchScreenEnabled +
                '}';
    }
}
