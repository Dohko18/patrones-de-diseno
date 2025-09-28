package co.edu.unisaba.car;

import co.edu.unisaba.car.model.TiresType;

public class Tire {

    private final String rin;
    private final String tractionGrade;
    private final String temperatureGrade;
    private final int speedRating;

    public Tire(TiresType type) {
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
                "rim='" + rin + '\'' +
                ", tractionGrade='" + tractionGrade + '\'' +
                ", temperatureGrade='" + temperatureGrade + '\'' +
                ", speedRating=" + speedRating +
                '}';
    }

}
