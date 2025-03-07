package com.example.project;
import java.util.ArrayList;


public class Player{
    private ArrayList<Card> hand;
    private ArrayList<Card> allCards; //the current community cards + hand
    String[] suits  = Utility.getSuits();
    String[] ranks = Utility.getRanks();
    
    public Player(){
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand(){return hand;}
    public ArrayList<Card> getAllCards(){return allCards;}

    public void addCard(Card c){
        hand.add(c);
    }
    public void delCards() {
        hand = new ArrayList<>();
    }

    public String playHand(ArrayList<Card> communityCards){
        String res = "";
        allCards = new ArrayList<Card>();
        allCards.addAll(hand);
        allCards.addAll(communityCards);
        int[] rf = findRankingFrequency();
        int[] sf = findSuitFrequency();
        int l1 = 0;
        for (int i = 0; i < rf.length; i++) {
            if (l1 == 0) {
                if (rf[i] == 1) {
                    l1++;
                }
            }else{
                if (rf[i] == 0) {
                    break;
                }else{
                    l1++;
                }
            }
        }
        if (l1 == 5) {
            for (int i : sf) {
                if (i == 5) {
                    if (rf[12] == 1) {
                        return "Royal Flush";
                    }else{
                        return "Straight Flush";
                    }
                }
            }
            return "Straight";
        }else{
            for (int i : sf) {
                if (i == 5) {
                    return "Flush";
                }
            }
            boolean thr = false;
            boolean tw = false;
            boolean tp = false;
            for (int i : rf) {
                if (i == 4){
                    return "Four of a Kind";
                }else if (i == 3) {
                    thr = true;
                }else if (i == 2){
                    if (tw) {
                        tp = true;
                    }else{
                        tw = true;
                    }
                }
            }
            if (tw) {
                if (thr) {
                    res = "Full House";
                }else{
                    if (tp) {
                        res = "Two Pair";
                    }else{
                        res = "A Pair";
                    }
                }
            }else if (thr) {
                res = "Three of a Kind";
            }else{
                int mx = 0;
                boolean n = true;
                for (Card cc1: communityCards){
                    int t = Utility.getRankValue(cc1.getRank());
                    if (t > mx) {
                        mx = t;
                    }
                }
                for (Card cc1: hand){
                    int t = Utility.getRankValue(cc1.getRank());
                    if (t > mx) {
                        n = false;
                        break;
                    }
                }
                if (n) {
                    res = "Nothing";
                }else{
                    res = "High Card";
                }
            }
        }
        return res;
    }

    public void sortAllCards(){} 

    public int[] findRankingFrequency(){
        int[] res = new int[13];
        for (Card c: allCards) {
            res[Utility.getRankValue(c.getRank()) - 2]++;
        }
        return res;
    }

    public int[] findSuitFrequency(){
        int[] res = new int[4];
        for (Card c: allCards) {
            switch (c.getSuit()) {
                case "♠":
                    res[0]++;
                    break;
                case "♥":
                    res[1]++;
                    break;
                case "♣":
                    res[2]++;
                    break;
                case "♦":
                    res[3]++;
                    break;
            }
        }
        return res;
    }

   
    @Override
    public String toString(){
        return hand.toString();
    }
}
