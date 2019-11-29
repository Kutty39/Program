package com.blbz.deckofcards.model;

import com.blbz.deckofcards.utility.MyQueue;

public class DeckofcardModel {
    private final String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final String[] Rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[][] fulldeck = new String[52][2];
    private String[][] shuffleddeck = new String[52][2];
    private String[][] p1 = new String[9][2];
    private String[][] p2 = new String[9][2];
    private String[][] p3 = new String[9][2];
    private String[][] p4 = new String[9][2];
    private MyQueue<MyQueue<String>> playerq = new MyQueue<>();
    private MyQueue<String> p1q= new MyQueue<>();
    private MyQueue<String> p2q= new MyQueue<>();
    private MyQueue<String> p3q=new MyQueue<>();
    private MyQueue<String> p4q=new MyQueue<>();

    public String[][] getFulldeck() {
        return fulldeck;
    }

    public void setFulldeck(String[][] fulldeck) {
        this.fulldeck = fulldeck;
    }

    public String[][] getShuffleddeck() {
        return shuffleddeck;
    }

    public void setShuffleddeck(String[][] shuffleddeck) {
        this.shuffleddeck = shuffleddeck;
    }

    public String[] getSuit() {
        return suit;
    }

    public String[] getRank() {
        return Rank;
    }

    public String[][] getP1() {
        return p1;
    }

    public void setP1(String[][] p1) {
        this.p1 = p1;
    }

    public String[][] getP2() {
        return p2;
    }

    public void setP2(String[][] p2) {
        this.p2 = p2;
    }

    public String[][] getP3() {
        return p3;
    }

    public void setP3(String[][] p3) {
        this.p3 = p3;
    }

    public String[][] getP4() {
        return p4;
    }

    public void setP4(String[][] p4) {
        this.p4 = p4;
    }

    public MyQueue<String> getP1q() {
        return p1q;
    }

    public void setP1q(MyQueue<String> p1q) {
        this.p1q = p1q;
    }

    public MyQueue<String> getP2q() {
        return p2q;
    }

    public void setP2q(MyQueue<String> p2q) {
        this.p2q = p2q;
    }

    public MyQueue<String> getP3q() {
        return p3q;
    }

    public void setP3q(MyQueue<String> p3q) {
        this.p3q = p3q;
    }

    public MyQueue<String> getP4q() {
        return p4q;
    }

    public void setP4q(MyQueue<String> p4q) {
        this.p4q = p4q;
    }

    public MyQueue<MyQueue<String>> getPlayerq() {
        return playerq;
    }

    public void setPlayerq(MyQueue<MyQueue<String>>  playerq) {
        this.playerq = playerq;
    }
}
