package com.rxjava.demo.demo1.observadores;

import com.rxjava.demo.demo1.observable.Observable;

public class HexaObservador extends Observador{

    public HexaObservador(Observable observable) {
        this.observable = observable;
        this.observable.inscribir(this);
    }

    @Override
    public void actualizar() {
        System.out.println("Hex :" + Integer.toHexString(observable.getEstado()).toUpperCase());
    }
}
