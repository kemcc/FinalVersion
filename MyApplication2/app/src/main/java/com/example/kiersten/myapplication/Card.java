/*Class Card
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */

 package com.example.kiersten.myapplication;

/* class Card. */
public class Card
{
	//Card face value.
	private int value;

    /* Constructor Card which takes an integer value.*/
    public Card(int aValue) {
        value = aValue;
    }
	
	//Get the value of a card.
	public int getValue() {

        return value;
	}
}