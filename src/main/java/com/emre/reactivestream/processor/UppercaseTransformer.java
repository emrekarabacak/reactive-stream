package com.emre.reactivestream.processor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import reactor.core.publisher.Flux;


@EnableBinding(Processor.class)
public class UppercaseTransformer {

    @StreamListener
    @Output(Processor.OUTPUT)
    public Flux<String> receive(@Input(Processor.INPUT) Flux<String> input) {
        return input.doOnEach(System.out::println)
                .map(String::toUpperCase);

    }

}
