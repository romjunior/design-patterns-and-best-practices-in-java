package com.exemplo.structural.bridge;

public class AllMessageClient extends MessageSender{

    private String to = "development_all@abc.com";

    public AllMessageClient(PlatformBridge implementation) {
        super(implementation);
    }

    public void sendMessageToAll(String from, String body) {
        sendMessage(from, to, body);
    }
}
