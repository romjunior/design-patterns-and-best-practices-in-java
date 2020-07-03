package com.exemplo.creational.factory.simple;

public class VehicleFactory {

    public enum VehicleType {
        TRUCK, CAR;
    }

    public static Vehicle create(VehicleType type) {
        if(type.equals(VehicleType.TRUCK)) {
            return new Truck();
        } else if(type.equals(VehicleType.CAR)) {
            return new Car();
        }
        return null;
    }

}
