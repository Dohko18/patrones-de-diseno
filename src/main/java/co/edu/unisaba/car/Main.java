package co.edu.unisaba.car;


import co.edu.unisaba.car.model.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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