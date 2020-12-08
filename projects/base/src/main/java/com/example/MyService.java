package com.example;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;

import javax.inject.Singleton;

@Singleton
public class MyService {
    
    @Value("${myservice.controller.message}")
    String message;

    @Property(name = "myservice.controller.message",defaultValue = "Default!")
    String message2;

    public String getMessage(){
        return message2;
    }
}
