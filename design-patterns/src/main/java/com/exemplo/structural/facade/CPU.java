package com.exemplo.structural.facade;

public class CPU {
    public void freeze() {
        System.out.println("Compute freezing...");
    }

    public void jump(final long position) {
        System.out.println("Jumping to... " + position);
    }

    public void execute() {
        System.out.println("Computer executing command...");
    }
}
