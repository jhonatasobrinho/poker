package com.bob.poker.controller;

import com.bob.poker.model.Player;
import com.bob.poker.service.GameEngine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PlayerController {

    private final GameEngine gameEngine;

    public PlayerController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @PostMapping("players")
    public Player createPlayer(Player player) {
        return gameEngine.addPlayer(player.getName());
    }
}
