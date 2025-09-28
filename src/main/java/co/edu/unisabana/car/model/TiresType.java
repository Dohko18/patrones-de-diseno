package co.edu.unisabana.car.model;

public enum TiresType {

    ESTANDAR_17("17 pulgadas", "A", "A", 210),
    DEPORTIVA_19("19 pulgadas", "AA", "A", 270),
    OFFROAD_20("20 pulgadas", "A", "A", 180);

    private final String rin;
    private final String tractionGrade;
    private final String temperatureGrade;
    private final int speedRating;

    TiresType(String rin, String tractionGrade, String temperatureGrade, int speedRating) {
        this.rin = rin;
        this.tractionGrade = tractionGrade;
        this.temperatureGrade = temperatureGrade;
        this.speedRating = speedRating;
    }

    public String getRin() {
        return rin;
    }

    public String getTractionGrade() {
        return tractionGrade;
    }

    public String getTemperatureGrade() {
        return temperatureGrade;
    }

    public int getSpeedRating() {
        return speedRating;
    }
}
