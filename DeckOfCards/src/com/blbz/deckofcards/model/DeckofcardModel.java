package com.blbz.deckofcards.model;

import com.blbz.deckofcards.utility.MyQueue;
import com.blbz.deckofcards.utility.Utility;

public class DeckofcardModel {
    private final String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final String[] Rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[][] fulldeck = new String[52][2];
    private String[][] shuffleddeck = new String[52][2];
    private String[] deckorder = new String[52];
    private String[][] p1 = new String[9][2];
    private String[][] p2 = new String[9][2];
    private String[][] p3 = new String[9][2];
    private String[][] p4 = new String[9][2];
    private MyQueue playerq = new MyQueue();
    private MyQueue p1q, p2q, p3q, p4q;

//    public String[][] getFulldeck() {
//        return fulldeck;
//    }
//
//    public void setFulldeck(String[][] fulldeck) {
//        this.fulldeck = fulldeck;
//    }
//
//    public String[][] getShuffleddeck() {
//        return shuffleddeck;
//    }
//
//    public void setShuffleddeck(String[][] shuffleddeck) {
//        this.shuffleddeck = shuffleddeck;
//    }
//
//    public String[] getSuit() {
//        return suit;
//    }
//
//    public String[] getRank() {
//        return Rank;
//    }
//
//    public String[] getDeckorder() {
//        return deckorder;
//    }
//
//    public void setDeckorder(String[] deckorder) {
//        this.deckorder = deckorder;
//    }
//
//    public String[][] getP1() {
//        return p1;
//    }
//
//    public void setP1(String[][] p1) {
//        this.p1 = p1;
//    }
//
//    public String[][] getP2() {
//        return p2;
//    }
//
//    public void setP2(String[][] p2) {
//        this.p2 = p2;
//    }
//
//    public String[][] getP3() {
//        return p3;
//    }
//
//    public void setP3(String[][] p3) {
//        this.p3 = p3;
//    }
//
//    public String[][] getP4() {
//        return p4;
//    }
//
//    public void setP4(String[][] p4) {
//        this.p4 = p4;
//    }

}
