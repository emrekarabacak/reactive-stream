package com.emre.reactivestream.source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@EnableBinding(GreetingStream.class)
public class ReactorHandler {

    @StreamListener
    public void handle(@Input(GreetingStream.INPUT) Flux<String> greetingFlux) {
        greetingFlux
                .subscribeOn(Schedulers.parallel())
                .subscribe(System.out::println);
    }
}

