package com.estudo.observable.buffer;

import io.reactivex.rxjava3.core.Observable;

public class Buffer {

    public static void main(String... args) {
        //faz um buffer e envia o length de valores em lista
        Observable.range(0, 10)
                .buffer(6).blockingSubscribe(System.out::println);
    }
}
