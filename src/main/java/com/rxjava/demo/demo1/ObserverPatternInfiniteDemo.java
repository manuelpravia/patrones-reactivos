package com.rxjava.demo.demo1;

import com.rxjava.demo.demo1.observable.Observable;
import com.rxjava.demo.demo1.observadores.BinaryObservador;
import com.rxjava.demo.demo1.observadores.HexaObservador;
import com.rxjava.demo.demo1.observadores.OctalObservador;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ObserverPatternInfiniteDemo {
    public static void main(String[] args) throws InterruptedException {

        Observable observable = new Observable();

        new HexaObservador(observable);
        new OctalObservador(observable);
        new BinaryObservador(observable);

        // Se comienzan los cambios de estados
        AtomicInteger atomicInteger = new AtomicInteger(0);
        while (true) {
            int randomNumber = new Random().nextInt(100);
            System.out.println("---------------------Observable emitido #"+atomicInteger.getAndIncrement()+"---------------------");
            System.out.println("Cambio de estado a: " + randomNumber);
            observable.setEstado(randomNumber);
            Thread.sleep(3000);
        }
    }
}
