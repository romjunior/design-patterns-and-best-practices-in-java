package com.exemplo.behavioral.templatemethod;

public interface DocumentTemplate {

    default void createDocumentHeader() {
        System.out.println("Creating a document header");
    }

    void createBodyDocument();

    default void createDocumentFooter() {
        System.out.println("Creating a document footer");
    }

    default void createDoc() {
        createDocumentHeader();
        createBodyDocument();
        createDocumentFooter();
    }

}
