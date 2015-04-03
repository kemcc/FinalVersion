/*Class MainScreenActivity
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */
package com.example.kiersten.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*MainScreenActivity implements interfaces inside GameBoardFragment, EndGameScreenFragment,
ChooseDeckFragment, and StartFragment.
 */
public class MainScreenActivity extends FragmentActivity implements ChooseDeckFragment.ChooseDeckListener,
        StartFragment.StartListener, EndGameScreenFragment.EndListener, GameBoardFragment.GameListener {

    //Create static AI and Player objects so that they can be accessed throughout fragments.
    static AI ai = new AI();
    static Player player = new Player();

    /*Inflate StartFragment opon start. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        addStartFragment();
    }

    //Gets the player.
    public static Player getPlayer() {
        return player;
    }

    //Gets the ai.
    public static AI getAI() {
        return ai;
    }

    //New Player and AI objects.
    public static void resetPlayers() {
        player = new Player();
        ai = new AI();
    }

    /**************Overriding ChooseDeckListener*********/
    //Draw from the main deck.
    @Override
    public void drawMain(View v) {
        //Makes sure that there are cards in main deck.
        if (player.getMainDeck().getLength() != 0) {
            player.addCardToHand(player.getMainDeck().drawFromDeck());
            //Switch fragment views.
            goToGameBoard();
        }
        //Check that both decks aren't empty; if so, then just go to gameboard.
        else if (player.getMainDeck().getLength() ==0 && player.getPersonalDeck().getLength() ==0) {
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, "Both decks empty.", duration);
            toast.show();
            goToGameBoard();
        }
        //If not, can't draw from main deck.
        else {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, "Main deck is empty.", duration);
            toast.show();
        }
    }

    //Draw from personal deck.
    @Override
    public void drawPersonal(View v) {
        if (player.getPersonalDeck().getLength() != 0) {
            player.addCardToHand(player.getPersonalDeck().drawFromDeck());
            goToGameBoard();
        }
        //If both decks empty, just go to game board.
        else if (player.getMainDeck().getLength() ==0 && player.getPersonalDeck().getLength() ==0) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, "Both decks empty.", duration);
            toast.show();

            goToGameBoard();
        }
        //Just personal deck empty.
        else {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, "Personal deck is empty.", duration);
            toast.show();
        }
    }
    /**************Overriding StartListener*********/
    //Presses "Start Game".  Go to draw deck fragment.
    @Override
    public void startGame(View v) {
        goToDrawDeck();
    }

    //Presses "Quit". Exits app.
    @Override
    public void quitGame(View v) {
        System.exit(0);
    }

    //Presses "Rules". DialogFragment pops up with rules.
    @Override
    public void readRules(View v) {
        openRules(this.findViewById(android.R.id.content));
    }

    /*Open the fragment containing rules. */
    public void openRules(View view) {
        RulesDialogFragment frag = new RulesDialogFragment();
        frag.show(getFragmentManager(), "RulesFragment");
    }

    /*Class RulesDialogFragment to display rules in a pop-up. */
    public static class RulesDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Rules");
            builder.setMessage("\t***Rules and Instructions***\n *Target is to reach 20 points before opponent\n *Any score over 20 loses the game"
                    + "\n *Main deck contains postive cards 1-10\n *Personal deck contains postive and negative cards 1-6"
                    + "\n *You can play one card per turn\n *To play a card from your hand, enter the corresponding integer"
                    + "\n *Hold if you are satisfied with your score\n *End to finish game now, player with score closest to 20 wins"
                    + "\n Press (OK) to go back");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //Just dismiss upon click.
                }
            });
            return builder.create();
        }
    }
    /**************Overriding EndListener*********/

    //Restarts game upon click of "New Game".
    @Override
    public void restartGame(View v) {
        resetPlayers();
        goToDrawDeck();
    }

    //Quits game when "Quit" pressed.
    @Override
    public void quitEndGame(View v) { System.exit(0);}


    /**************Overriding GameListener*********/

    /*Methods for when buttons in GameBoardFragment pressed.  Not optimal
    to have six methods, however we were unable to come up with a solution
    to optimize it.  In the future this can be optimized.
     */
    @Override
    public void buttonPressedA(View v) {
        Button pressed = (Button) this.findViewById(R.id.buttonA);
        //Get value of button.
        String value = pressed.getText().toString();
        //If value is 0, means that there is no card there.  Displays Toast.
        if (value.equals("0")) {
            invalidCardMessage();
        }
        //Otherwise, parse string as an integer and play the card.
        else {
            playCard(new Card(Integer.parseInt(pressed.getText().toString())));
        }
    }

    @Override
    public void buttonPressedB(View v) {
        Button pressed = (Button) this.findViewById(R.id.buttonB);
        String value = pressed.getText().toString();
        if (value.equals("0")) {
            invalidCardMessage();
        }
        else {
            playCard(new Card(Integer.parseInt(pressed.getText().toString())));
        }

    }

    @Override
    public void buttonPressedC(View v) {
        Button pressed = (Button) this.findViewById(R.id.buttonC);
        String value = pressed.getText().toString();
        if (value.equals("0")) {
            invalidCardMessage();
        }
        else {
            playCard(new Card(Integer.parseInt(pressed.getText().toString())));
        }
    }

    @Override
    public void buttonPressedD(View v) {
        Button pressed = (Button) this.findViewById(R.id.buttonD);
        String value = pressed.getText().toString();
        if (value.equals("0")) {
            invalidCardMessage();
        }
        else {
            playCard(new Card(Integer.parseInt(pressed.getText().toString())));
        }
    }

    @Override
    public void buttonPressedE(View v) {
        Button pressed = (Button) this.findViewById(R.id.buttonE);
        String value = pressed.getText().toString();
        if (value.equals("0")) {
            invalidCardMessage();
        }
        else {
            playCard(new Card(Integer.parseInt(pressed.getText().toString())));
        }
    }

    @Override
    public void buttonPressedF(View v) {
        Button pressed = (Button) this.findViewById(R.id.buttonF);
        String value = pressed.getText().toString();
        if (value.equals("0")) {
            invalidCardMessage();
        }
        else {
            playCard(new Card(Integer.parseInt(pressed.getText().toString())));
        }
    }
    //User clicks the "Hold" button. AI's turn.
    @Override
    public void hold(View v) {
        Toast.makeText(this, "Hold.", Toast.LENGTH_SHORT).show();
        checkGameOver();
        AIPlay();
    }

    //User pressed the "End Game" button.  Pops up a dialog asking
    //if they want to end game.  If so, go to end game fragment.
    @Override
    public void toEndGame (View v) {
        AlertDialog.Builder endGame = new AlertDialog.Builder(this);

        endGame.setTitle("End Game?");
        //If presses yes, goes to end game.
        endGame.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                goToEndGame();
            }
        });
        //If presses no, just go back to previous screen.
        endGame.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = endGame.create();
        dialog.show();
    }

    //Toast that pops up when invalid card value pressed.
    public void invalidCardMessage() {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, "Invalid card.", duration);
        toast.show();
    }

    //Method called after user is done their turn.
    public void AIPlay() {
        ai.choosePlay();
        if (player.getScore() >= 20 || ai.getScore() >= 20 || ai.getHoldCounter() >=2) {
            goToEndGame();
        }
        else {
            goToDrawDeck();
        }

    }

    public void checkGameOver() {
        //check to see that player's score is not >=20,
        //if AI's score is >= 20, or if AI's hold counter
        //is > than what it should be.

        if (player.getScore() >= 20 || ai.getScore() >= 20 || ai.getHoldCounter() >=2) {
            goToEndGame();
        }
    }

    //Plays card of player by adding the value to score, then checks if
    //end game conditions met or not.
    public void playCard (Card card) {
        player.playCard(card.getValue());
        if (player.getScore() >= 20 || ai.getScore() >= 20 || ai.getHoldCounter() >=2) {
            goToEndGame();
        }
        else {
            AIPlay();
        }

    }

    /****Methods to switch between fragments.****/

   /*Switches to ChooseDeckFragment. */
    public void goToDrawDeck() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ChooseDeckFragment drawFrag = new ChooseDeckFragment();
        transaction.replace(R.id.frag_container, drawFrag);
        transaction.commit();
    }

    /*Switches to EndGameScreenFragment. */
    public void goToEndGame() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        EndGameScreenFragment endGameFrag = new EndGameScreenFragment();
        transaction.replace(R.id.frag_container, endGameFrag);
        transaction.commit();
    }

    /*Switches to GameBoardfragment. */
    public void goToGameBoard() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        GameBoardFragment gameScreenFrag = new GameBoardFragment();
        transaction.replace(R.id.frag_container, gameScreenFrag);
        transaction.commit();
    }

    /*Switches to StartFragment. */
    private void addStartFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        StartFragment startScreenFrag = new StartFragment();
        transaction.replace(R.id.frag_container, startScreenFrag);
        transaction.commit();
    }
}