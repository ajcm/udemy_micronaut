package com.example.broker.store;

import com.example.broker.model.Quote;
import com.example.broker.model.Symbol;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.Utils.getRandom;

@Singleton
public class InMemoryStore {
    private List<Symbol> symbols;
    private Map<String,Quote> quotes;

    public InMemoryStore(){
        symbols = Stream.of("AAPL","AMZN","FB")
                .map(Symbol::new)
                .collect(Collectors.toList());
        quotes  = new HashMap<>();
        symbols.forEach(symbol -> quotes.put(symbol.getValue(),getRandomQuote(symbol)));

    }

    public List<Symbol> getAllSymbols(){
        return symbols;
    }

    public Optional<Quote> getQuote(String symbol) {
        return Optional.ofNullable(quotes.get(symbol));
    }

    public void update(Quote quote) {
        quotes.put(quote.getSymbol().getValue(),quote);
    }

    private Quote getRandomQuote(Symbol symbol) {
        return  Quote.builder().symbol(symbol)
                .bid(getRandom())
                .ask(getRandom())
                .volume(getRandom())
                .build();
    }
}
