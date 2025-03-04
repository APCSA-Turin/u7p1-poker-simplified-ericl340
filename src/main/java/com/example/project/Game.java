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
        p1h += p1c1 > p1c2 ? p1c1 : p1c2;
        p2h += p2c1 > p2c2 ? p2c1 : p2c2;
        return p1h > p2h ? "Player 1 wins!" : p2h == p1h ? "Tie!" : "Player 2 wins!";
    }

    public static void play(){ //simulate card playing
    
    }
        
        

}