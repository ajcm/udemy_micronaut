package com.example;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.List;

@MicronautTest
public class MarketsControllerTest {
    @Inject
    EmbeddedApplication<?> application;

    @Inject
    MyConfig myConfig;

    @Inject @Client("/")
    RxHttpClient client;

    @Value("${myservice.controller.message}")
    String message;

    @Test
    void testGetAll(){
        List<LinkedHashMap<String,String>> result = client.toBlocking().retrieve("/markets",List.class);
        assertThat(result)
                .extracting(e -> e.get("value"))
                .containsExactlyInAnyOrder("AAPL","AMZN","FB");

    }


}
