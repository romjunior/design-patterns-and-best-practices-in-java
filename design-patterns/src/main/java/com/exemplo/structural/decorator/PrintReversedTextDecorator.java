package com.exemplo.structural.decorator;

public class PrintReversedTextDecorator implements PrintText{

    private final PrintText inner;

    public PrintReversedTextDecorator(PrintText inner) {
        this.inner = inner;
    }

    @Override
    public void print(String text) {
        inner.print(new StringBuilder(text).reverse().toString());
    }
}
