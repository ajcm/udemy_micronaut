package com.example;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class MyControllerTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject @Client("/")
    RxHttpClient client;


    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testHelloResponse(){
        String result = client.toBlocking().retrieve("/");
        Assertions.assertEquals("Hello",result);

    }

}