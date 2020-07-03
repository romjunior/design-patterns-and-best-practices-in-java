package com.exemplo.creational.factory.method;

public class CarFactory extends VehicleFactory{

    @Override
    protected Vehicle createVehicle(String item) {
        if(item.equals("small"))
            return new SportCar();
        else if(item.equals("large"))
            return new SedanCar();
        return null;
    }
}
