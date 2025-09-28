package co.edu.unisaba.car;

import co.edu.unisaba.car.model.ColorType;
import co.edu.unisaba.car.model.RoofType;


import java.util.Objects;


public class Car {

    private  final ColorType color;
    private  final String brand;
    private  final String model;
    private  final RoofType roofType;
    private  final Tire tire;
    private  final Engine engine;
    private final SoundSystem sound;
    private final GPS gpsNavigation;


    protected Car(CarBuilder builder) {
        color = builder.color;
        brand = builder.brand;
        model = builder.model;
        roofType = builder.roofType;
        tire = builder.tire;
        engine = builder.engine;
        sound = builder.sound;
        gpsNavigation = builder.GPS;
    }

    public ColorType getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public RoofType getRoofType() {
        return roofType;
    }

    public Tire getTire() {
        return tire;
    }

    public Engine getEngine() {
        return engine;
    }

    public SoundSystem getSound() {
        return sound;
    }

    public GPS getGpsNavigation() {
        return gpsNavigation;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return gpsNavigation == car.gpsNavigation && color == car.color && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && roofType == car.roofType && Objects.equals(tire, car.tire) && Objects.equals(engine, car.engine) && sound == car.sound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, brand, model, roofType, tire, engine, sound, gpsNavigation);
    }

    @Override
    public String toString() {
        return "Car {\n" +
                "   brand='" + brand + '\'' + ",\n" +
                "   model='" + model + '\'' + ",\n" +
                "   color=" + color + ",\n" +
                "   roofType=" + roofType + ",\n" +
                "   tire=" + (tire != null ? tire : "N/A") + ",\n" +
                "   engine=" + (engine != null ? engine : "N/A") + ",\n" +
                "   soundSystem=" + (sound != null ? sound : "N/A") + ",\n" +
                "   gpsNavigation=" + (gpsNavigation != null ? gpsNavigation : "N/A") +  "\n" +
                '}';
    }


}
