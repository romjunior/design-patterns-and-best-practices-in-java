package com.exemplo.creational.factory.method;

public class Main {

    public static void main(String... args) {
        VehicleFactory vehicleFactory = new CarFactory();
        Vehicle car = vehicleFactory.orderVehicle("small", "blue");
        System.out.println(car.getColor());
    }

}
