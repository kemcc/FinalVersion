/*Class AI.  Extends class Player.
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */
package com.example.kiersten.myapplication;
import java.util.Random;

public class AI extends Player{
    Random random;
    int holdCounter = 0;
    public AI () {
        super();
        random = new Random();
    }

    //AI holds if score is 16 or higher
    public boolean dealersRule () {
        return (score > 15);
    }

    //Draws from either personal deck or main deck.
    public void randomDrawDeck() {
        switch(random.nextInt(2)) {	//choose 0 or 1
            case 0:		addCardToHand(mainDeck.drawFromDeck());
                break;
            case 1:		addCardToHand(personalDeck.drawFromDeck());
                break;
            default:	//draw from main deck
                addCardToHand(mainDeck.drawFromDeck());
                break;
        }
    }

    /*AI plays.  If dealers rule returns true, will hold.  Otherwise,
    will play a card from their hand.
     */
    public void choosePlay() {
        //Draws from main deck or personal deck.
        randomDrawDeck();
        if (!dealersRule()) {
            //choose random card to play
            Card card = null;
            //Makes sure card isn't null.
            while (card == null) {
                card = hand.getCard(random.nextInt(hand.getLength()));
            }
            playCard(card.getValue());

        }
        else {
            hold();
            holdCounter++;
        }
    }

    //returns hold counter value.
    public int getHoldCounter() {
        return holdCounter;
    }
}
