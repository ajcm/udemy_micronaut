package com.example;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton @Slf4j
public class MyService {
    private final static Logger LOG = LoggerFactory.getLogger(MyService.class);

    @Value("${myservice.controller.message}")
    String message;

    @Property(name = "myservice.controller.message",defaultValue = "Default!")
    String message2;

    public String getMessage(){
        return message2;
    }

    @EventListener
    public void onStartup(StartupEvent event){
        LOG.info("Startup: {}",event.toString());
        log.info("Startup: {}",event.toString());
    }
}
