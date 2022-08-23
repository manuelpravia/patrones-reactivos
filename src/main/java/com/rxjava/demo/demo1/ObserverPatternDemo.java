package com.rxjava.demo.demo1;

import com.rxjava.demo.demo1.observable.Observable;
import com.rxjava.demo.demo1.observadores.BinaryObservador;
import com.rxjava.demo.demo1.observadores.HexaObservador;
import com.rxjava.demo.demo1.observadores.OctalObservador;

public class ObserverPatternDemo {
    public static void main(String[] args) {

        Observable observable = new Observable();

        new HexaObservador(observable);
        new OctalObservador(observable);
        new BinaryObservador(observable);


        System.out.println("--- Cambio de estado: 15 ---");
        observable.setEstado(15);
        System.out.println("--- Cambio de estado: 10 ---");
        observable.setEstado(10);
    }
}
