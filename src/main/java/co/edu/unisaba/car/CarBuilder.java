package co.edu.unisaba.car;

import co.edu.unisaba.car.model.*;

import java.util.List;

public class CarBuilder implements IBuilder<Car> {

    protected final ColorType color;
    protected String brand;
    protected String model;
    protected RoofType roofType;
    protected List<Tire> tires;
    protected Tire tire;
    protected Engine engine;
    protected SoundSystem sound;
    protected GPS GPS;

    public static CarBuilder builder(ColorType color) {
        return new CarBuilder(color);
    }

    @Override
    public Car build() {
        return new Car(this);
    }

    private CarBuilder(ColorType color) {
        this.color = color;
    }

    public CarBuilder brand(String val) {
        brand = val;
        return this;
    }

    public CarBuilder model(String val) {
        model = val;
        return this;
    }

    public CarBuilder roof(RoofType val) {
        roofType = val;
        return this;
    }

    public CarBuilder tire(TiresType val) {
        tire = new Tire(val);
        return this;
    }

    public CarBuilder engine(EngineType val) {
        engine = new Engine(val);
        return this;
    }

    public CarBuilder sound(SoundSystemType val) {
        sound = new SoundSystem(val);
        return this;
    }

    public CarBuilder gpsNavigation(NavigationType val) {
        GPS = new GPS(val);
        return this;
    }


}
