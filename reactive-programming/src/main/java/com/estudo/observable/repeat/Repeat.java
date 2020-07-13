package com.estudo.observable.repeat;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.atomic.AtomicReference;

public class Repeat {

    public static void main(String... args) {
        AtomicReference<Integer> i = new AtomicReference<>(0);
        Observable.just('a')
                //.repeat()
                //.repeatUntil(() -> i.getAndSet(i.get() + 1) > 2)
                .subscribe(System.out::println);
    }
}
