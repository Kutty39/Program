package com.blbz.deckofcards.seviceimp;

import com.blbz.deckofcards.model.DeckofcardModel;
import com.blbz.deckofcards.service.Deckofcard;

import java.util.Random;


public class DeckofcardImp implements Deckofcard {
    DeckofcardModel dm;
    public DeckofcardImp(){
       dm= new DeckofcardModel();
    }
    @Override
    public void fullDeckCreater() {
        int pos = 0;
        for (String s : dm.getSuit()) {
            for (String s1 : dm.getRank()) {
                dm.getFulldeck()[pos][0] = s1;
                dm.getFulldeck()[pos][1] = s;
                dm.getDeckorder()[pos] = s1 +""+ s;
                ++pos;
            }
        }
    }

    @Override
    public void shuffleCards() {
        setShuffleddeck(getFulldeck());
        Random rd = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                int r = rd.nextInt(52);
                int r1 = rd.nextInt(52);

                String[] temp = getShuffleddeck()[r];
                getShuffleddeck()[r] = getShuffleddeck()[r1];
                getShuffleddeck()[r1] = temp;
            }
        }
        // setShuffleddeck(getShuffleddeck());
/*        for (String[] strings : getShuffleddeck()) {
            System.out.println(strings[0]+" "+strings[1]);
        }*/
    }

    @Override
    public void putCardtoPlayers() {
        int pos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j + 1) {
                    case 1:
                        getP1()[i] = getShuffleddeck()[pos];
                        break;
                    case 2:
                        getP2()[i] = getShuffleddeck()[pos];
                        break;
                    case 3:
                        getP3()[i] = getShuffleddeck()[pos];
                        break;
                    case 4:
                        getP4()[i] = getShuffleddeck()[pos];
                        break;
                }
                ++pos;
            }
        }
        System.out.println("Player 1      \tPlayer 2      \tPlayer 3      \tPlayer 4");
        for (int i = 0; i < getP1().length; i++) {
            String p1 = getP1()[i][0] + " " + getP1()[i][1];
            String p2 = getP2()[i][0] + " " + getP2()[i][1];
            String p3 = getP3()[i][0] + " " + getP3()[i][1];
            String p4 = getP4()[i][0] + " " + getP4()[i][1];
            System.out.print(p1 + " ".repeat(14 - p1.length()) + "\t" +
                    p2 + " ".repeat(14 - p2.length()) + "\t" +
                    p3 + " ".repeat(14 - p3.length()) + "\t" +
                    p4);
            System.out.println();
        }
    }
}
