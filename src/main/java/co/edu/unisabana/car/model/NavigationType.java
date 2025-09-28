package co.edu.unisabana.car.model;

public enum NavigationType {
    BASICO("Garmin","DriveSmart 65"),
    AVANZADO("TomTom", "GO Supreme 6"),
    MULTIMEDIA("Pioneer", "AVIC-W8500NEX");

    private final String brand;
    private final String model;

    NavigationType(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
