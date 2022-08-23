package com.rxjava.demo.demo1.observadores;

import com.rxjava.demo.demo1.observable.Observable;

public class BinaryObservador extends Observador{

    public BinaryObservador(Observable observable) {
        this.observable = observable;
        this.observable.inscribir(this);
    }

    @Override
    public void actualizar() {
        System.out.println("Binary String: " + Integer.toBinaryString(observable.getEstado()));
    }
}
