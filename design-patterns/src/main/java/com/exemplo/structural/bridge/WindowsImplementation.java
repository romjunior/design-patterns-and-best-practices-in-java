package com.exemplo.structural.bridge;

public class WindowsImplementation implements PlatformBridge{

    @Override
    public void forwardMessage(String msg) {
        System.out.printf("Sending message \n%s \nFrom the windows machine", msg);
    }

}
