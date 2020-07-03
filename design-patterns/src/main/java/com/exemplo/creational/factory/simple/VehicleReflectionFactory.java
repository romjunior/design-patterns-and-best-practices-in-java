package com.exemplo.creational.factory.simple;

import java.util.HashMap;
import java.util.Map;

public class VehicleReflectionFactory {

    private Map<String, Class> registeredProducts = new HashMap<>();

    public void registerVehicle(String vehicleId, Class vehicleClass) {
        registeredProducts.put(vehicleId, vehicleClass);
    }

    public Vehicle createVehicle(String type) throws InstantiationException, IllegalAccessException {
        final Class productClass = registeredProducts.get(type);
        return (Vehicle) productClass.newInstance();
    }

}
