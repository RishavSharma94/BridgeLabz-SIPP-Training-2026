import java.util.*;

public class DeckOfCards {

    public static void main(String[] args) {

        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        String[] deck = new String[52];
        int index = 0;

        // create deck
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }

        // shuffle
        for (int i = 0; i < deck.length; i++) {
            int r = i + (int)(Math.random() * (deck.length - i));

            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

        // print cards
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i]);
        }
    }
}