/*Class PersonalDeck
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */

 package com.example.kiersten.myapplication;

public class PersonalDeck extends Deck
{
	// Holds -1,1,....,-6,6 cards

    private static final int PERSONAL_SIZE = 4;
	public PersonalDeck () {
		/*Maximum deck size of four cards randomly
		 * selected.
		 */
		 cards = randomizeDeck();
	}

	//Get four random card values for personal deck.
	private Card[] randomizeDeck() {
		Deck temp = new Deck(PERSONAL_SIZE);
		for (int i=0; i<PERSONAL_SIZE;i++) {
			/* randValue = random value from 1-6
			 * randSign = +/-
			 * signedValue = (randSign) randValue
			 */
			int randValue = randomizer.nextInt(6)+1; //Between 1 and 6
			int randSign = randomizer.nextInt(1);  //1 = positive, 0 = negative
			int signedValue;

            //If a 0, then make value negative.  If 1, make value positive.
			switch (randSign) {
				case 0:
					signedValue = -randValue;
					break;
					
				//if not 0, then it is 1
				default:
					signedValue = randValue;	
					break;
			}
			//Add to temporary deck.
			temp.addToDeck(new Card(signedValue));
		}
		return temp.toArray();
	}
}