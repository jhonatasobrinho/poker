package com.bob.poker.model;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Deck {
    private List<Card> cards = new ArrayList<>();
}
