package com.estudo.observable.empty;

import io.reactivex.rxjava3.core.Observable;

public class ObservableEmpty {

    public static void main(String... args) {
        //criar um observable vazio, ou que nunca vai mandar itens
        Observable.empty();
        Observable.never();
    }
}
