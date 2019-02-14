package com.bob.poker.service;

import com.bob.poker.model.Deck;
import com.bob.poker.model.Game;
import com.bob.poker.model.Player;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@ApplicationScope
public class GameEngine {

    private Deck deck;
    private List<Game> games = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public GameEngine(Deck deck) {
        this.deck = deck;
    }

    public Player addPlayer(String name) {
        Player player = new Player(name);
        players.add(player);
        return player;
    }

    public Game startGame(List<Player> players) {
        Game game = new Game(deck, players);

        games.add(game);

        return game;
    }
}
