package com.example.broker;

import com.example.broker.model.Symbol;
import com.example.broker.store.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.List;

@Controller("/markets")
public class MarketsController {

    @Inject
    private InMemoryStore store;

    @Get("/")
    public List<Symbol> getAll(){
        return store.getAllSymbols();
    }


}
