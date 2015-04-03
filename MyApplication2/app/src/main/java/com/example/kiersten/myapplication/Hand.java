/*Class Hand
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */

 package com.example.kiersten.myapplication;

/*Class Hand that extends Deck. */
public class Hand extends Deck {

    //Constructor that accepts a size and creates an empty deck.
	public Hand(int size) {
		super(size);
	}
	
	/*Overridden method from Deck, tailored so that the hand does 
	 * not decrease in size.
	 */
	@Override
	public void deleteFromArray(int index) {
        //Create new empty array equal in size to hand.
		Card[] temp = new Card[(cards.length)];

		//Copy all except the deleted card to temp array.
		for (int i=0; i<(temp.length);i++) {
			if (i>=index) {
				if (i >= temp.length-1) {
					temp[i] = null;
				}
				else {
					//Add the i+1 card if  i>= index.
					temp[i] = cards[i+1];
				}				
			}
			//Add the ith card otherwise.
			else {
				temp[i] = cards[i];
			}
		}
		cards = temp;
	}
}