package com.blbz.deckofcards.controller;
       /*
Created by : Mr. Tamilselvan S
Created on : 15/11/2019
Purpose of Creating : deck of cards having suit ("Clubs", "Diamonds", "Hearts", "Spades")
 & Rank ("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace").
  Shuffle the cards using Random method and then distribute 9 Cards to 4 Players and Print the Cards the received by the 4 Players using 2D Array
 */

import com.blbz.deckofcards.service.Deckofcard;
import com.blbz.deckofcards.seviceimp.DeckofcardImp;

public class Main {

    public static void main(String[] args) {
        Deckofcard dc = new DeckofcardImp();
        dc.fullDeckCreater();
        dc.shuffleCards();
        dc.putCardtoPlayers();
        dc.creatingPlayerQ();
        dc.displayQ();
    }
}
