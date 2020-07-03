package com.exemplo.structural.bridge;

public class MessageSender {
    private PlatformBridge implementation;

    public MessageSender(PlatformBridge implementation) {
        this.implementation = implementation;
    }

    public void sendMessage(String from, String to, String body) {
        implementation.forwardMessage(String.format("From : %s \nTo : %s \nBody : %s", from, to, body));
    }
}
