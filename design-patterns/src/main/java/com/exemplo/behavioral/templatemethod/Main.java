package com.exemplo.behavioral.templatemethod;

public class Main {

    public static void main(String... args) {
        DocumentTemplate csv = new Csv();
        csv.createDoc();
        DocumentTemplate xml = new XML();
        xml.createDoc();
    }
}
