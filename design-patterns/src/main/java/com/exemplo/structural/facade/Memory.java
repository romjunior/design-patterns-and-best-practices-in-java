package com.exemplo.structural.facade;

public class Memory {

    public void load(final long position, byte[] data) {
        System.out.println("Loading data to memory... " + position);
    }
}
