package com.estudo.observable.defer;

import io.reactivex.rxjava3.core.Observable;

public class ObservableDefer {

    public static void main(String... args) {
        //cria um observable para cada observer que é conectado a ele.
        Observable<Integer> a = Observable.defer(() -> Observable.just(123));
        a.subscribe(System.out::println);
    }
}
