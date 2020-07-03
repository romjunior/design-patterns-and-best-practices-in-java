package com.exemplo.structural.bridge;

public class Main {

    public static void main(String... args) {
        new AllMessageClient(new WindowsImplementation())
                .sendMessageToAll("teste@teste.com.br", "vai dormir");
    }

}
