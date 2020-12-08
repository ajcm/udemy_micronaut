package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("${myservice.controller.path:/hello}")
public class MyController {

    @Inject
    MyService myService;

    @Inject
    MyConfig myConfig;

    @Get("/")
    public String index(){
        return myService.getMessage();
    }

    @Get("/en")
    public String indexEn(){
        return myConfig.getEn();
    }

    @Get("/de")
    public String indexDe(){
        return myConfig.getDe();
    }

}
