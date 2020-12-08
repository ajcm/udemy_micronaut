package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("${myservice.controller.path:/hello}")
public class MyController {

    @Inject
    MyService myService;

    @Get("/")
    public String index(){
        return myService.getMessage();
    }

}
