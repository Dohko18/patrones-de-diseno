package co.edu.unisaba.car.model;

import java.math.BigDecimal;

public enum EngineType {
    G_V6("V6", "Gasolina", 320, 400, new BigDecimal("1.00")),
    G_V8("V8", "Gasolina", 450, 600, new BigDecimal("0.85")),
    DIESEL("V6", "Diesel", 250, 500, new BigDecimal("1.20")),
    HIBRIDO("L4", "Híbrido", 200, 350, new BigDecimal("1.50")),
    ELECTRICO("N/A", "Eléctrico", 300, 600, new BigDecimal("2.00"));

    private final String engineType;
    private final String fuelType;
    private final int  hosePower;
    private final int torque;
    private final BigDecimal price;

    EngineType(String engineType, String fuelType, int hosePower, int torque, BigDecimal price) {
        this.engineType = engineType;
        this.fuelType = fuelType;
        this.hosePower = hosePower;
        this.torque = torque;
        this.price = price;
    }

    public String getEngineType() {return engineType;}
    public String getFuelType() {return fuelType;}
    public int getHosePower() {return hosePower;}
    public int getTorque() {return torque;}
    public BigDecimal getPrice() {return price;}
}
