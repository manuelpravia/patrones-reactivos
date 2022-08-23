package com.rxjava.demo.demo1.observadores;

import com.rxjava.demo.demo1.observable.Observable;

public abstract class Observador {

    protected Observable observable;

    public abstract  void actualizar();
}
