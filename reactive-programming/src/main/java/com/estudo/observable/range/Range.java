package com.estudo.observable.range;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Range {

    public static void main(String... args) {
        Observable.range(1, 10).subscribe(System.out::println);
        Observable.intervalRange(1, 10, 1, 2, TimeUnit.SECONDS)
                .blockingLatest() //usado para dar block na main e não finalizar o programa antes
                .forEach(System.out::println);
    }
}
