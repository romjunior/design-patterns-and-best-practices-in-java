package com.exemplo.structural.bridge;

public class PosixImplementation implements PlatformBridge{

    @Override
    public void forwardMessage(String msg) {
        System.out.printf("Sending message \n%s \nFrom the Linux machine", msg);
    }

}
