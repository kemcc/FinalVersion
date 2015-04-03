/*Class Player
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */

 package com.example.kiersten.myapplication;

public class Player {

    //maximum capacity for cards in hand is 6.
    protected final int HAND_SIZE = 6;

    //Score of played cards.
    protected int score = 0;
    protected PersonalDeck personalDeck;
    protected MainDeck mainDeck;
    protected Hand hand;

    //Default constructor.
    public Player () {
        mainDeck = new MainDeck();
        personalDeck = new PersonalDeck();
        hand = new Hand(HAND_SIZE);
        addInitialCardsToHand();
    }

    //Adds 4 cards at beginning to hand from main deck.
    protected void addInitialCardsToHand() {
        for (int i=0; i<4; i++) {
            addCardToHand(mainDeck.drawFromDeck());
        }
    }

    //Adds a card to hand.
    public void addCardToHand(Card card) {
        int i=0;

        //If index 0 is null, add card to it (empty hand case).
        if (hand.getCard(0) == null) {
            hand.addToDeck(card);
        }
        else {
            //There is a card in i, so increment until find empty spot.
            while (hand.getCard(i) != null && i <HAND_SIZE) {
                i++;
            }
            //After empty spot found, add to hand if card isn't null.
            if (card !=null && i<HAND_SIZE) {

                //There is an empty spot in hand, otherwise card not added.
                if (hand.getCard(i) == null) {
                    hand.addToDeck(card);
                    System.out.println("Card drawn: ["+card.getValue()+"]");
                }
            }
        }
    }

    //Delete a card from hand.
    public void deleteCardFromHand(Card card) {
        int i=0;
        for ( ; i<hand.getLength()-1;i++) {
            if (hand.getCard(i).getValue() == card.getValue()) {
                //Card value found, call deleteFromArray.
                hand.deleteFromArray(i);
                break;
            }
        }
    }

    //Plays a card from hand.  Score is updated and card deleted
    //from hand.
    public void playCard(int value) {
        addToScore(value);
        deleteCardFromHand(new Card(value));
    }

    //Method for when player chooses to hold.  Nothing is changed.
    public void hold() {
        System.out.println("Player holds.");
    }

    //Get hand.
    public Hand getHand() {
        return hand;
    }

    //Get personal deck.
    public PersonalDeck getPersonalDeck () {
        return personalDeck;
    }

    //Get main deck.
    public MainDeck getMainDeck() {
        return mainDeck;
    }

    //Get score.
    public int getScore () {
        return score;
    }
    //Adds number to score.
    public void addToScore (int score) {
        this.score += score;
    }
    //Checks score.  Returns true if >20.
    public boolean checkScore () {
        return (score >20);
    }
}