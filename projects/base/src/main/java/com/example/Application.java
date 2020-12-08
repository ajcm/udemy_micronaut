package com.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private final static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = Micronaut.run(Application.class, args);

        MyService myService = context.getBean(MyService.class);
        LOG.info("Started : " + myService.getMessage());
    }
}
