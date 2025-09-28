package co.edu.unisabana.car;

import co.edu.unisabana.car.model.*;

import java.util.List;

public class CarBuilder implements IBuilder<Car> {

    protected final ColorType color;
    protected String brand;
    protected String model;
    protected RoofType roofType;
    protected Tire tire;
    protected Engine engine;
    protected SoundSystem sound;
    protected GPS gps;

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
        this.brand = val;
        return this;
    }

    public CarBuilder model(String val) {
        this.model = val;
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
        this.gps = new GPS(val);
        return this;
    }


}
