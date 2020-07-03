package com.exemplo.behavioral.templatemethod;

public class Csv implements DocumentTemplate{

    @Override
    public void createBodyDocument() {
        System.out.println("creating csv document body");
    }
}
