package com.estudo.observable.create;
import io.reactivex.rxjava3.core.Observable;

public class ObservableCreate {

    public static void main(String... args) {
        Observable.create(emitter -> {
            try {
                if(!emitter.isDisposed()) {
                    for(int i = 1; i < 5; i++) {
                        emitter.onNext(i);
                    }
                    emitter.onComplete();
                }
            }catch (Exception e) {
                emitter.onError(e);
            }
        }).subscribe(System.out::println, System.err::println, () -> System.out.println("Sequence Complete"));
    }
}
