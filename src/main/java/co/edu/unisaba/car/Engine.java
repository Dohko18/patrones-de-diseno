package co.edu.unisaba.car;

import co.edu.unisaba.car.model.EngineType;

import java.math.BigDecimal;

public class Engine {
    private final String engineType;
    private final String fuelType;
    private final int horsePower;
    private final int torque;
    private final BigDecimal price;

    public Engine(EngineType engineType) {
        this.engineType = engineType.getEngineType();
        this.fuelType = engineType.getFuelType();
        this.horsePower = engineType.getHosePower();
        this.torque = engineType.getTorque();
        this.price = engineType.getPrice();
    }

    public String getEngineType() {
        return engineType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getTorque() {
        return torque;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineType='" + engineType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", horsePower=" + horsePower +
                ", torque=" + torque +
                ", price=" + price +
                '}';
    }
}
