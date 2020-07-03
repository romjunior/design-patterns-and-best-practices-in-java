package com.exemplo.behavioral.strategy;

public class Main {

    public static void main(String... args) {
        System.out.println(Context.getOperation("ADD").operate(1 ,2 ));
        System.out.println(Context.getOperation("MINUS").operate(1 ,2 ));
        System.out.println(Context.getOperation("MULTIPLY").operate(1 ,2 ));
    }

}
