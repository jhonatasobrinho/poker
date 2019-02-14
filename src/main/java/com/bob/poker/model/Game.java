package com.bob.poker.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private Deck deck;
    private List<Player> players = new ArrayList<>();

    private List<Card> table = new ArrayList<>();

    public Game(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
    }
}
