package com.exemplo.structural.facade;

public class Main {
    public static void main(String... args) throws Exception {
        CoffeeMachineFacade facade = new SuperstarCoffeeMachine();
        facade.serveCoffee();
    }
}
