package com.exemplo.behavioral.templatemethod;

public class XML implements DocumentTemplate{

    @Override
    public void createBodyDocument() {
        System.out.println("Creating XML Document");
    }
}
