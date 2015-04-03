/*Class Deck
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */
 package com.example.kiersten.myapplication;

import java.util.Random;

public class Deck
{
	//Maximum size of any deck.
    protected static final int MAX_DECK_SIZE = 40;
	protected Card[] cards = null;
    //Random number generator
	protected Random randomizer = new Random();
	
	//Default constructor.  Creates null array of size 40.
    public Deck () {
        this(MAX_DECK_SIZE);
    }

	//Constructor that accepts a size and creates an empty deck.
	public Deck (int size) {
		cards = new Card[size];
		for (int index = 0; index < size; index++) {
			cards[index] = null;
		}
	}

	//Deletes a card from an array using index parameter.
	public void deleteFromArray(int index) {
        //New array with one less spot.
		Card[] temp = new Card[(cards.length)-1];
		
		//Copy all except the deleted card to temp array.
		for (int i=0; i<(temp.length);i++) {
			if (i>=index) {
				
				//Add the i+1 card if  i>= index.
				temp[i] = cards[i+1];
			}

			//Add the ith card otherwise.
			else {
				temp[i] = cards[i];
			}
		}
		cards = temp;
	}
	
	/*Add a card to end of deck.  */
	public void addToDeck(Card c) {
        for (int i=0; i<cards.length;i++) {
            if (cards[i] ==null) {
                cards[i] =c;
                break;
            }
        }
    }
	
	/*Draws a card from deck.  Does not draw a card
	 * if the deck is empty.
	 * */
	public Card drawFromDeck() {
		//Deck is empty.
		if (cards.length ==0) {
            //Return a card of value 0,
            //deck is empty.
			return new Card(0);
		}

		int randIndex = randomizer.nextInt(cards.length);

		//Get card from random index of deck.
		Card card = getCard(randIndex);

        //Delete card drawn from array.
		deleteFromArray(randIndex);
		
		//Problem.  This shouldn't occur.
		if (card == null) {
            //just return card with value of 0.
            return new Card(0);
		}
		return card;
	}
	
	//Get card from deck based on index.
	public Card getCard(int index) {
		for (int i=0; i<cards.length; i++) {
			if (i==index) {
				return cards[i];
			}
		}
        //Otherwise, no card found.
		return null;
	}

	
	//Get the length of the deck.
	public int getLength() {
		return cards.length;
	}

	
	//Return array of deck.
	public Card[] toArray() {
		return cards;
	}
}