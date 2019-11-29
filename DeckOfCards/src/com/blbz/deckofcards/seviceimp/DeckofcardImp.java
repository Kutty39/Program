package com.blbz.deckofcards.seviceimp;

import com.blbz.deckofcards.model.DeckofcardModel;
import com.blbz.deckofcards.service.Deckofcard;
import com.blbz.deckofcards.utility.MyQueue;

import java.util.Arrays;
import java.util.Random;


public class DeckofcardImp implements Deckofcard {
    DeckofcardModel dm;
//Constructor will create the object of the model class
    public DeckofcardImp() {
        dm = new DeckofcardModel();
    }

    /*
    This methode will create the full deck with order
     */

    @Override
    public void fullDeckCreater() {
        int pos = 0;
        for (String s : dm.getSuit()) {
            for (String s1 : dm.getRank()) {
                dm.getFulldeck()[pos][0] = s1;
                dm.getFulldeck()[pos][1] = s;
                ++pos;
            }
        }
    }

    /*
    this will shuffle the full deck and create new shuffled deck
     */
    @Override
    public void shuffleCards() {
        dm.setShuffleddeck(dm.getFulldeck().clone());
        Random rd = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                int r = rd.nextInt(52);
                int r1 = rd.nextInt(52);

                String[] temp = dm.getShuffleddeck()[r];
                dm.getShuffleddeck()[r] = dm.getShuffleddeck()[r1];
                dm.getShuffleddeck()[r1] = temp;
            }
        }

    }

    /*
    Distributing cards to all the players one by one.
    and printing the 2d array
     */
    @Override
    public void putCardtoPlayers() {
        int pos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j + 1) {
                    case 1:
                        dm.getP1()[i] = dm.getShuffleddeck()[pos];
                        break;
                    case 2:
                        dm.getP2()[i] = dm.getShuffleddeck()[pos];
                        break;
                    case 3:
                        dm.getP3()[i] = dm.getShuffleddeck()[pos];
                        break;
                    case 4:
                        dm.getP4()[i] = dm.getShuffleddeck()[pos];
                        break;
                }
                ++pos;
            }
        }

        System.out.println("2d Array");
        System.out.println("Player 1      \tPlayer 2      \tPlayer 3      \tPlayer 4");
        for (int i = 0; i < dm.getP1().length; i++) {
            String p1 = dm.getP1()[i][0] + " " + dm.getP1()[i][1];
            String p2 = dm.getP2()[i][0] + " " + dm.getP2()[i][1];
            String p3 = dm.getP3()[i][0] + " " + dm.getP3()[i][1];
            String p4 = dm.getP4()[i][0] + " " + dm.getP4()[i][1];
            System.out.print(p1 + " ".repeat(14 - p1.length()) + "\t" +
                    p2 + " ".repeat(14 - p2.length()) + "\t" +
                    p3 + " ".repeat(14 - p3.length()) + "\t" +
                    p4);
            System.out.println();
        }
    }

    /*
    creating the q for all the players
     */
    @Override
    public void creatingPlayerQ() {
        for (String[] strings : dm.getP1()) {
            dm.getP1q().enQueue(strings[0]+" "+strings[1],findRank(strings));
            //System.out.println(strings[0]+" "+strings[1]+" "+findRank(strings));
        }
        for (String[] strings : dm.getP2()) {
            dm.getP2q().enQueue(strings[0]+" "+strings[1],findRank(strings));
            //System.out.println(strings[0]+" "+strings[1]+" "+findRank(strings));
        }
        for (String[] strings : dm.getP3()) {
            dm.getP3q().enQueue(strings[0]+" "+strings[1],findRank(strings));
            //System.out.println(strings[0]+" "+strings[1]+" "+findRank(strings));
        }
        for (String[] strings : dm.getP4()) {
            dm.getP4q().enQueue(strings[0]+" "+strings[1],findRank(strings));
            //System.out.println(strings[0]+" "+strings[1]+" "+findRank(strings));
        }
        dm.getPlayerq().enQueue( dm.getP1q(),1);
        dm.getPlayerq().enQueue( dm.getP2q(),2);
        dm.getPlayerq().enQueue( dm.getP3q(),3);
        dm.getPlayerq().enQueue( dm.getP4q(),4);
    }

    /*
    displaying the q for all the players
     */
    public void displayQ(){
        System.out.println("*****************");
        System.out.println("using Q");
        System.out.println("*****************");
        int py=1;
        while (dm.getPlayerq().size()!=0){
            MyQueue<String> tmpw= dm.getPlayerq().deQueus();
            if (py==1){
                System.out.println("Player 1");
            }else if(py==2){
                System.out.println("Player 2");
            }else if(py==3){
                System.out.println("Player 3");
            }else{
                System.out.println("Player 4");
            }
            while (tmpw.size()!=0){
                System.out.println(tmpw.deQueus());
            }
            System.out.println("************************");
            ++py;
        }
    }

    /*
    to find the index of the card from full deck
     */
    private int findRank(String[] str) {
        for (int i = 0; i < dm.getFulldeck().length; i++) {
            if (Arrays.equals(dm.getFulldeck()[i], str)) {
                return i;
            }
        }
        return -1;
    }

}
