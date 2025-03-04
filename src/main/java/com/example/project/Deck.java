package com.example.project;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public  void initializeDeck(){ //hint.. use the utility class
        String[] r = Utility.getRanks();
        String[] s = Utility.getSuits();
        for (int i = 0; i < r.length; i++) {
            for (int k = 0; k < s.length; k++) {
                cards.add(new Card(r[i], s[k]));
            }
        }
    }

    public  void shuffleDeck(){ //You can use the Collections library or another method. You do not have to create your own shuffle algorithm
        Collections.shuffle(cards);
    }

    public  Card drawCard(){
       return cards.remove(0);
    }

    public  boolean isEmpty(){
        return cards.isEmpty();
    }

   


}