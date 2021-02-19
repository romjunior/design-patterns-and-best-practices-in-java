package com.exemplo.structural.facade;

public class Main {

    public static void main(String... args) {
        ComputerFacade computerFacade = new ComputerFacade(new CPU(), new Memory(), new HardDrive());
        computerFacade.start();
    }
}
