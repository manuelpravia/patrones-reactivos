package com.rxjava.demo.demo2;


import io.reactivex.Observable;

public class HighLevelLifecycle {
    public static void main(String[] args) {
        Observable<Integer> exampleObservable = Observable.just(1,2,3);
        exampleObservable.subscribe(System.out::println);
        System.out.println("-----------------");
        exampleObservable.subscribe(System.out::println);
        System.out.println("-------------------------");
    }
}
