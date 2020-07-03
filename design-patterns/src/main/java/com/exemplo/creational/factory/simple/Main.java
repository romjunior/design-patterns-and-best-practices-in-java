package com.exemplo.creational.factory.simple;

public class Main {

    public static void main(String... args) throws IllegalAccessException, InstantiationException {
        Vehicle car = VehicleFactory.create(VehicleFactory.VehicleType.CAR);
        Vehicle truck = VehicleFactory.create(VehicleFactory.VehicleType.TRUCK);
        car.drive();
        truck.drive();

        VehicleReflectionFactory factory = new VehicleReflectionFactory();
        factory.registerVehicle("car", Car.class);

        Vehicle car2 = factory.createVehicle("car");
        car2.drive();
    }

}
