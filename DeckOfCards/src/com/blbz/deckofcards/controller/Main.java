package com.blbz.deckofcards.controller;

import com.blbz.deckofcards.service.Deckofcard;
import com.blbz.deckofcards.seviceimp.DeckofcardImp;

public class Main {

    public static void main(String[] args) {
        Deckofcard dc= new DeckofcardImp();
        dc.fullDeckCreater();
        dc.shuffleCards();
       dc.putCardtoPlayers();
    }
}
