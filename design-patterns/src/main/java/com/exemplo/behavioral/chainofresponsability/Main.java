package com.exemplo.behavioral.chainofresponsability;

public class Main {

    public static void main(String... args) {
        CarHandler handler1 = new Mechanic(null);
        CarHandler handler2 = new Transmission(handler1);
        CarHandler handler3 = new Electric(handler2);

        Car car = new Car.Builder()
                .setColor("blue")
                .setType("basic")
                .build();

        handler3.handleCar(car, "electric");
    }
}
