package co.edu.unisabana.car;

import co.edu.unisabana.car.model.TiresType;

public class Tire {

    private final String rin;
    private final String tractionGrade;
    private final String temperatureGrade;
    private final int speedRating;

    public Tire(TiresType type) {
        if (type == null) {
            throw new IllegalArgumentException("TiresType cannot be null");
        }
        this.rin = type.getRin();
        this.tractionGrade = type.getTractionGrade();
        this.temperatureGrade = type.getTemperatureGrade();
        this.speedRating = type.getSpeedRating();
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

    @Override
    public String toString() {
        return "Tire{" +
                "rin='" + rin + '\'' +
                ", tractionGrade='" + tractionGrade + '\'' +
                ", temperatureGrade='" + temperatureGrade + '\'' +
                ", speedRating=" + speedRating +
                '}';
    }

}
