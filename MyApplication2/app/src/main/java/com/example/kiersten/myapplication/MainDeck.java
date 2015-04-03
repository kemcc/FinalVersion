/*Class MainDeck
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */

 package com.example.kiersten.myapplication;
/* Class MainDeck.  Holds cards from values 1-10, four of each
 * number. */

public class MainDeck extends Deck
{
	public MainDeck() {
		//Fill deck with array of cards.
		cards = fillDeck();		
	}
	private Card[] fillDeck() {
	
		//Initial card value.
		int value = 1;
		
		//Temporary deck of size 40.
		Deck temp = new Deck(MAX_DECK_SIZE);
		
		//Index counter.
		int j = 0;
		while (j <MAX_DECK_SIZE) {
			//i = amount of cards for each value.
			for (int i =0; i<4; i++) {
				
				//Fill temporary deck.
				temp.addToDeck(new Card(value));
				j++;
			}
            //New value.
			value++;
		}
		return temp.toArray();
	}
}