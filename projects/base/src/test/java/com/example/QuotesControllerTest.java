package com.example;

import com.example.broker.error.CustomError;
import com.example.broker.model.Quote;
import com.example.broker.model.Symbol;
import com.example.broker.store.InMemoryStore;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Optional;

import static com.example.Utils.getRandom;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@MicronautTest
public class QuotesControllerTest {
    @Inject
    EmbeddedApplication<?> application;

    @Inject @Client("/")
    RxHttpClient client;


    @Inject
    private InMemoryStore store;

    @Test
    void testGetQuote(){
        Quote apple = Quote.builder().symbol(new Symbol("AAPL"))
                .bid(getRandom())
                .ask(getRandom())
                .volume(getRandom())
                .build();

        store.update(apple);

        Quote result = client.toBlocking().retrieve("/quotes/AAPL",Quote.class);
        log.debug("quote: {}",result);
        Assertions.assertThat(apple).isEqualToComparingFieldByField(result);

    }

    @Test
    void testGetQuoteNotFound(){

        try {
            Quote result = client.toBlocking().retrieve("/quotes/APL", Quote.class);
            log.debug("quote: {}", result);
        }catch (HttpClientResponseException ex){
            assertEquals(HttpStatus.NOT_FOUND,ex.getStatus());
            Optional<CustomError> error = ex.getResponse().getBody(CustomError.class);

            assertTrue(error.isPresent());
            assertEquals(error.get().getStatus(),HttpStatus.NOT_FOUND.getCode());
            return;

        }
       Assertions.fail("shouln't reach here");

    }



}
