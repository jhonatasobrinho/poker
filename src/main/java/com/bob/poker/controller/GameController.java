package com.bob.poker.controller;

import com.bob.poker.model.Game;
import com.bob.poker.model.Player;
import com.bob.poker.service.GameEngine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    private final GameEngine engine;

    public GameController(GameEngine engine) {
        this.engine = engine;
    }

    // it will be called when you POST at /api/games
    @PostMapping("/api/games")
    public Game createGame(List<Player> players) {
        return engine.startGame(players);
    }

    // it will be called when you GET /api/games
    @GetMapping("/api/games")
    public List<Game> fetchAllGames() {
        return engine.getGames();
    }
}
