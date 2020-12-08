package com.example.broker;

import com.example.broker.error.CustomError;
import com.example.broker.model.Quote;
import com.example.broker.store.InMemoryStore;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;


import javax.inject.Inject;
import java.util.Optional;

@Controller("/quotes")
public class QuotesController {

    @Inject
    private InMemoryStore store;

    @Get("/{symbol}")
    public HttpResponse getQuote(@PathVariable String symbol){
        Optional<Quote> optQuote = store.getQuote(symbol);
        if (optQuote.isEmpty()){
            CustomError notFound = CustomError.builder()
                    .status(HttpStatus.NOT_FOUND.getCode())
                    .error(HttpStatus.NOT_FOUND.name())
                    .message("message")
                    .path("/quote/")
                    .build();

            return HttpResponse.notFound(notFound);
        }else {
            return HttpResponse.ok(optQuote.get());
        }
    }

}
