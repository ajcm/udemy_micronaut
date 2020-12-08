package com.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = Micronaut.run(Application.class, args);

        MyService myService = context.getBean(MyService.class);

        System.out.println(myService.getMessage());

    }
}
