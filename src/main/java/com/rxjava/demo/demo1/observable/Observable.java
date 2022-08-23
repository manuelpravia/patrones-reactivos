package com.rxjava.demo.demo1.observable;


import com.rxjava.demo.demo1.observadores.Observador;

import java.util.ArrayList;
import java.util.List;


public class Observable {

    private List<Observador> observadores = new ArrayList<>();
    private  int estado;

    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
        notificarObservadores();
    }
    public  void inscribir(Observador observador){
        observadores.add(observador);
    }

    public void notificarObservadores(){
        for(Observador observador:observadores){
            observador.actualizar();
        }
    }

}
