package co.edu.unisaba.car;

import co.edu.unisaba.car.model.NavigationType;

/**
 * @author Ing. Darwin Esneider Rodriguez Ladino
 * @version Id: <b>task-first</b> 26/09/2025, 9:47 p. m.
 * @email daroxx47@hotmail.com
 **/
public class GPS {
    private final String brand;
    private final String model;

    public GPS(NavigationType navigationType) {
        this.brand = navigationType.getBrand();
        this.model = navigationType.getModel();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
