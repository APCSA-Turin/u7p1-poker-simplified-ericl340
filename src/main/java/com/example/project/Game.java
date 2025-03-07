package com.example.project;
import java.util.ArrayList;


public class Game{
    public static String determineWinner(Player p1, Player p2,String p1Hand, String p2Hand,ArrayList<Card> communityCards){
        int p1h = Utility.getHandRanking(p1Hand) * 15;
        int p2h = Utility.getHandRanking(p2Hand) * 15;
        int p1c1 = Utility.getRankValue(p1.getHand().get(0).getRank());
        int p1c2 = Utility.getRankValue(p1.getHand().get(1).getRank());
        int p2c1 = Utility.getRankValue(p2.getHand().get(0).getRank());
        int p2c2 = Utility.getRankValue(p2.getHand().get(1).getRank());
        if (p1c1 > p1c2) {
            p1h += p1c1;
        }else{
            p1h += p1c2;
        }
        if (p2c1 > p2c2) {
            p2h += p2c1;
        }else{
            p2h += p2c2;
        }
        if (p1h > p2h) {
            return "Player 1 wins!";
        }else if (p2h == p1h) {
            return "Tie!";
        }else{
            return "Player 2 wins!";
        }
    }

    public static void play(){ //simulate card playing
        Deck d = new Deck();
        d.shuffleDeck();
        Player p1 = new Player();
        Player p2 = new Player();
        ArrayList<Card> cc = new ArrayList<Card>();
        cc.add(d.drawCard());
        cc.add(d.drawCard());
        cc.add(d.drawCard());
        p1.addCard(d.drawCard());
        p1.addCard(d.drawCard());
        p2.addCard(d.drawCard());
        p2.addCard(d.drawCard());
        System.out.println(cc);
        System.out.println(p1.playHand(cc));
        System.out.println(p1.getHand());
        System.out.println(p2.playHand(cc));
        System.out.println(p2.getHand());
        System.out.println(determineWinner(p1, p2, p1.playHand(cc), p2.playHand(cc), cc));;
    }
    public static void main(String[] args) {
        play();
    }
        

}