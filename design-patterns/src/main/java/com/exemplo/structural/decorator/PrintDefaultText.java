package com.exemplo.structural.decorator;

public class PrintDefaultText implements PrintText{
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
