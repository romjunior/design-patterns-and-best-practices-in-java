package com.exemplo.creational.builder;

public class Main {

    public static void main(String... args) {
        Car car = new Car.Builder()
                .setColor("blue")
                .setType("sport")
                .build();
    }

}
