package com.exemplo.creational.factory.method;

public abstract class VehicleFactory {
    protected abstract Vehicle createVehicle(String item);
    public Vehicle orderVehicle(String size, String color) {
        Vehicle vehicle = createVehicle(size);
        vehicle.setColor(color);
        return vehicle;
    }
}
