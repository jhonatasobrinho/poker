package com.bob.poker;

import com.bob.poker.model.Card;
import com.bob.poker.model.CardSuit;
import com.bob.poker.model.Deck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ComponentScan(basePackages = "com.bob.poker")
@SpringBootApplication
public class PokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokerApplication.class, args);
    }

    @Bean
    public Deck deck() {
        // get all number cards
        String[] numbers = IntStream.rangeClosed(2, 10).boxed().map(String::valueOf).toArray(String[]::new);
        List<Card> numberCards = getCardsOfRangeOfNumbers(numbers);

        // get all not number cards
        String[] notNumbers = Stream.of("A", "Q", "J", "K").toArray(String[]::new);
        numberCards.addAll(getCardsOfRangeOfNumbers(notNumbers));

        // creates a deck out of these cards
        return new Deck(numberCards);
    }

    // String... is an array of Strings of mutable quantity of elements
    private List<Card> getCardsOfRangeOfNumbers(String... numbers) {
        // Get all suits of a number
        return Stream.of(numbers)
                .map(number -> getCardsOfNumber(String.valueOf(number)))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Card> getCardsOfNumber(final String number) {
        return Stream.of(CardSuit.values()).map(cardSuit -> new Card(number, cardSuit)).collect(Collectors.toList());
    }

}

