package com.exemplo.structural.proxy;

import com.exemplo.structural.proxy.proxy.Proxy;

public class ProxyPatternEx {

    public static void main(String[] args) {
        System.out.println("***Proxy Pattern Demo***\n");
        Proxy px = new Proxy();
        px.doSomeWork();
    }

}
