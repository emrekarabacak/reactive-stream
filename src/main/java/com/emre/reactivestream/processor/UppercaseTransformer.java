package com.emre.reactivestream.processor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;

import javax.annotation.processing.Processor;

@EnableBinding(Processor.class)
@EnableAutoConfiguration
public class UppercaseTransformer {

    

}
