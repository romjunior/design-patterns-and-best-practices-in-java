package com.exemplo.structural.decorator;

public class PrintUpperCaseTextDecorator implements PrintText{

    private final PrintText inner;

    public PrintUpperCaseTextDecorator(PrintText inner) {
        this.inner = inner;
    }

    @Override
    public void print(String text) {
        inner.print(text.toUpperCase());
    }
}
