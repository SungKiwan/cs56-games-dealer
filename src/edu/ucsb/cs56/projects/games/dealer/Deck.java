package edu.ucsb.cs56.projects.games.dealer;
import java.util.*;
import java.lang.*;
import java.security.*;

/**
 This class is to provide functions to a standard 52 cards deck such as shuffling.

 @author Jeremy White and Andrew Cooney
 @author Antonio Cantor
 @version cs56 W14 3/13/14
 */

public class Deck {

    private ArrayList<Card> deck;


    /**
    Deck constructor to make deck arraylist contained an unshuffle deck.
     */

    public Deck(){
	deck=new ArrayList<Card>();
	String[] suits={"Spade","Heart","Club","Diamond"};
	String[] ranks={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	for(int i=0;i<4;i++){
	    for(int j=0;j<13;j++){
		deck.add(new Card(ranks[j],suits[i]));
	    }
	}
    }

    /**
     This function is used to shuffle the deck
     by using the shuffle function from the Collections
     class and a SecureRandom seed. It randomly permutes deck using
     the seed.
     */

    public void shuffle(){
		//Creates the seed
		SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[64];
        random.nextBytes(bytes);
		
        //Shuffles the deck with a 64 bit seed 
		Collections.shuffle(deck,random);
    }

    /**
     Overridden toString function to print cards remaining in the deck.

	@return deckResult a string of the cards remaining in the deck
     */
	
	public String toString(){
		String deckResult="Your deck"+"\n";
		//Only one card to add to deckResult
		if (deck.size()==1){
            deckResult+=deck.get(0);
        }		
        else{	
            for (int i = 0; i<deck.size(); i++){
                //5 cards per line
				if (i%5==0){
                    deckResult+="\n";
				}
				//No comma at the end of the string
                if(i == deck.size()-1){
                    deckResult+=deck.get(i);
                }
                else{
                    deckResult+=deck.get(i) + ", ";
                }
            }
			//deck is empty
			if (deck.size()==0){
				deckResult="NO MORE CARDS IN THE DECK";
			}
        }
		return 	deckResult;
	}


    /**
	 Removes cards from the deck by xCards

     @param xCards the number of cards user inputted
     */

	public void removeCard(int xCards){
		int i = 0;
		//Loops up to index xCard-1 in the deck
		//Using an Iterator instead of using for loop is safer
		//There won't be an index out of bounds exception
		for(Iterator<Card> iterator = deck.iterator(); 
		    iterator.hasNext();) {
		    Card card = iterator.next();
		    if(i<xCards){
			//removes first element in the ArrayList
			iterator.remove();
			i++;
		    }
		}
	}



    /**
     This function is gain access to the deck array.

	 @return deck the ArrayList of deck
     */
	
	//Necessary for dealer class and addtoHand function in Hand class
    public ArrayList<Card> getDeck(){
        return deck;
    }

}
