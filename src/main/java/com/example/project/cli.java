package com.example.project;
import java.util.ArrayList;
import java.util.Scanner;
public class cli{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        Player p1 = new Player();
        Player p2 = new Player();
        ArrayList<Card> community = new ArrayList<Card>();
        l: while (true) {
            System.out.println("0. Exit\n1. Reset\n2. Shuffle\n3. View Community Cards\n4. View Hand Cards\n5. Draw Cards\n6. Winner");
            switch (scan.nextInt()) {
                case 0:
                    break l;
                case 1:
                    p1.delCards();
                    p2.delCards();
                    community = new ArrayList<Card>();
                    deck.initializeDeck();
                    deck.shuffleDeck();
                    System.out.println("Reset!");
                    break;
                case 2:
                    deck.shuffleDeck();
                    System.out.println("Shuffled!");
                    break;
                case 3:
                    System.out.println("Community Cards:\n" + community);
                    break;
                case 4:
                System.out.println("Player 1:\n" + p1.getHand());
                System.out.println("Player 2:\n" + p2.getHand());
                    break;
                case 5:
                    if (deck.getCards().size() < 7) {
                        System.out.println("Error: Not Enough Cards");
                        break;
                    }
                    p1.delCards();
                    p2.delCards();
                    community = new ArrayList<Card>();
                    p1.addCard(deck.drawCard());
                    p2.addCard(deck.drawCard());
                    p1.addCard(deck.drawCard());
                    p2.addCard(deck.drawCard());
                    community.add(deck.drawCard());
                    community.add(deck.drawCard());
                    community.add(deck.drawCard());
                    System.out.println("Cards Drawn!");
                    break;
                case 6:
                    if (community.size() != 3) {
                        System.out.println("Error: Draw Cards First");
                        break;
                    }
                    String p1h = p1.playHand(community);
                    String p2h = p2.playHand(community);
                    System.out.println("Player 1: " + p1h + "\nPlayer 2: " + p2h);
                    System.out.println(Game.determineWinner(p1, p2, p1h, p2h, community));
                    break;
            }
        }
    }
}
