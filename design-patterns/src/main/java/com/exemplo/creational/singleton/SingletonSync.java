package com.exemplo.creational.singleton;

public class SingletonSync {

    private static SingletonSync instance;

    private SingletonSync() {
        System.out.println("Singleton sync está instanciado");
    }

    public static synchronized SingletonSync getInstance() {
        if(instance == null) {
            instance = new SingletonSync();
        }
        return instance;
    }

    public static SingletonSync getInstanceBlock() {
        synchronized (SingletonSync.class) {
            if(instance == null) {
                instance = new SingletonSync();
            }
        }
        return instance;
    }

    public static SingletonSync getInstanceBlockDoubleCheck() {
        if(instance == null) {
            synchronized (SingletonSync.class) {
                if(instance == null) {
                    instance = new SingletonSync();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Faz alguma coisa sync");
    }

}
