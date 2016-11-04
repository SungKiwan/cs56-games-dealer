package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;
import java.lang.*;


/**
 *   This class is used to add cards to the hand.
 *
 * @author Antonio Cantor
 * @version cs56 W14 3/13/14
 */

public class Hand {
    private ArrayList<Card> hand;
    private int handSize;

    /**
     * Hand constructor to make hand arraylist be an empty hand
     * and the handSize be 0.
     */

    public Hand() {
        hand = new ArrayList<Card>();
        handSize=0;
    }

    /**
     * Add a number of cards to the hand
     *
     * @param numCards number of cards to draw
     * @param d the deck to draw from
     */

     public void addtoHand(int numCards, Deck d) {
         d.draw(numCards, this);
	 handSize += numCards;
    }

    /**
     * @return an ArrayList containing each card in the hand
     */
     public ArrayList<Card> getHand() {
	return hand;
    }

    /**
     * Overridden toString function to print cards in the hand.
     *
     * @return handResult a string of the cards in the hand
     */

    public String toString() {
        String result = "Your hand:\n";
	for(int i = 0; i < handSize - 1; i++) {
	    result += hand.get(i) + ", ";
	}
	result += hand.get(handSize - 1);
	return result;
    }
}
