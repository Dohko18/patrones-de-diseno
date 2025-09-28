package co.edu.unisabana.car;


import co.edu.unisabana.car.model.*;

public class Main {
    public static void main(String[] args) {
        createCar();
    }

    private static void createCar(){
        Car toyota = CarBuilder
                .builder(ColorType.AZUL)
                .brand("Toyota")
                .roof(RoofType.PANORAMICO)
                .engine(EngineType.DIESEL)
                .tire(TiresType.OFFROAD_20)
                .gpsNavigation(NavigationType.MULTIMEDIA)
                .sound(SoundSystemType.SURROUND)
                .model("2025")
                .build();

        System.out.println("Toyota: \n" + toyota);
    }

}