package com.estudo.observable.interval;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Interval {

    public static void main(String... args) {
        Observable.interval(1, TimeUnit.SECONDS)
        .map(tick -> tick.longValue()).subscribe(System.out::println);
    }
}
