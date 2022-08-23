package com.rxjava.demo.demo4;
import com.rxjava.demo.utility.GateBasedSynchronization;
import com.rxjava.demo.utility.datasets.GreekAlphabet;
import com.rxjava.demo.utility.subscribers.DemoCompletableObserver;
import com.rxjava.demo.utility.subscribers.MaybeDemoSubscriber;
import com.rxjava.demo.utility.subscribers.SingleDemoSubscriber;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DemoModule1CardinalityExample {

    private final static Logger log = LoggerFactory.getLogger(DemoModule1CardinalityExample.class);

    public static void main(String[] args) {

        // My synchronization magic.  Let's keep this thread from exiting
        // until all of our test code has executed.
        GateBasedSynchronization gate = new GateBasedSynchronization();

        // Single result stream
        Single<String> firstGreekLetterOnly = Observable.fromArray(GreekAlphabet.greekLetters)
                .first("?");

        // Maybe result stream - First letter (alpha)
        Maybe<String> maybeGreekLetterOneEvent = Observable.fromArray(GreekAlphabet.greekLetters)
                .first("?")
                .filter( nextLetter -> nextLetter.equals("\u03b1"));

        // Maybe result stream - No letters
        Maybe<String> maybeGreekLetterNoEvents = Observable.fromArray(GreekAlphabet.greekLetters)
                .first("?")
                .filter( nextLetter -> !nextLetter.equals("\u03b1"));

        // Completable result stream - No output to subscriber, only success or failure.
        Completable completableObserver = Observable.fromArray(GreekAlphabet.greekLetters)
                .ignoreElements();

        // --------------------------------------------------------------------------------------
        // See what happens with the events when we subscribe to each of them...
        // --------------------------------------------------------------------------------------
        log.info( "Single -----------------------------------------------------");
        firstGreekLetterOnly.subscribe(new SingleDemoSubscriber<>(gate, "onError", "onSuccess"));

        log.info( "------------------------------------------------------------");
        log.info( "" );
        log.info( "Maybe (1 result) -------------------------------------------");

        gate.resetAll();

        maybeGreekLetterOneEvent.subscribe(new MaybeDemoSubscriber<>(gate, "onError", "onSuccess", "onComplete"));

        log.info( "------------------------------------------------------------");
        log.info( "" );
        log.info( "Maybe (0 results) -------------------------------------------");
        gate.resetAll();

        maybeGreekLetterNoEvents.subscribe(new MaybeDemoSubscriber<>(gate, "onError", "onSuccess", "onComplete"));

        log.info( "------------------------------------------------------------");
        log.info( "" );
        log.info( "Completable ------------------------------------------------");
        gate.resetAll();

        completableObserver.subscribe(new DemoCompletableObserver( gate, "onError" , "onComplete"));
    }
}
