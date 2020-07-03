package com.exemplo.creational.singleton;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton está instanciado");
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Faz alguma coisa");
    }

}
