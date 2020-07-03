package com.exemplo.creational.singleton;

public class LockFreeSingleton {

    private static final LockFreeSingleton instance = new LockFreeSingleton();

    private LockFreeSingleton() {
        System.out.println("Lock Free Singleton está instanciado");
    }

    public static LockFreeSingleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("faz alguma coisa lock free");
    }

}
