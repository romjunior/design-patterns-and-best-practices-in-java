package com.exemplo.structural.decorator;

public class Main {

    public static void main(String... args) {
        PrintText text = new PrintDefaultText();
        text.print("Isso é um texto");
        PrintText upper = new PrintUpperCaseTextDecorator(text);
        upper.print("Isso e outro texto");
        PrintText reversed = new PrintReversedTextDecorator(text);
        reversed.print("Isso e mais um texto");
        PrintText reversedUpper = new PrintReversedTextDecorator(upper);
        reversedUpper.print("Esse texto e doido");
    }

}
