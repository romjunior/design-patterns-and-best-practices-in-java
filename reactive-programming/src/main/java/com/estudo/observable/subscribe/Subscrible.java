package com.estudo.observable.subscribe;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Subscrible {

    public static void main(String... args) {
        Observable<Long> numbers = Observable.intervalRange(1, 3, 1, 2, TimeUnit.SECONDS);

        //subscribe padrão que possui callbacks de onNext, onError e onCompleted
        numbers.subscribe(System.out::println, System.err::println, () -> System.out.println(10));

        //consome cada item emitido pelo Observable e bloqueia ate ele terminar
        numbers.blockingForEach(System.out::println);

        //sobreescreve no Observable e consome cada evento na thread atual
        numbers.blockingSubscribe(System.out::println);

        //sobreescreve no Observable e recebe notificações para cada elemento
        //numbers.forEach(System.out::println);


    }
}
