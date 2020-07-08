package com.estudo.observable.from;

import io.reactivex.rxjava3.core.Observable;

public class ObservableFrom {

    public static void main(String... args) {
        //operador from usado para criar a partir de arrays, futures e outros objetos
        Observable<Integer> a = Observable.fromArray(new Integer[]{1, 2, 3});
    }
}
