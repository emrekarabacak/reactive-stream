package com.emre.reactivestream.source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import reactor.core.publisher.Flux;

import java.time.Duration;

@EnableBinding(GreetingStream.class)
public class ReactorEmitter {

    @StreamEmitter
    @Output(GreetingStream.OUTPUT)
    public Flux<String> emit() {
        return Flux.interval(Duration.ofMillis(1000))
                .map(val -> "Hello World " + val);
    }
}
