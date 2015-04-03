/*Class GameBoardFragment
*
* SENG 301 Project by Kiersten Mort,
* Christopher Miller, and Karen McCowan.
*
* April 2nd, 2015
* */
package com.example.kiersten.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

    public class GameBoardFragment extends Fragment {
        /*Get player and ai from MainScreenActivity. */
        Player player = MainScreenActivity.getPlayer();
        AI ai = MainScreenActivity.getAI();
        GameListener game;

        /*Buttons and player's score. The buttons are not
        * created in a for loop, which is inefficient, however
        * we were having issues with setting the text in the buttons.
        * In the future this can be optimized. */
        private static TextView playerScore;
        private static Button buttonA;
        private static Button buttonB;
        private static Button buttonC;
        private static Button buttonD;
        private static Button buttonE;
        private static Button buttonF;

        //Array version of player's hand.
        Card[] playerHand = player.getHand().toArray();

        /*Interface GameListener. */
        public interface GameListener {
            public void buttonPressedA(View v);
            public void buttonPressedB(View v);
            public void buttonPressedC(View v);
            public void buttonPressedD(View v);
            public void buttonPressedE(View v);
            public void buttonPressedF(View v);
            public void hold(View v);
            public void toEndGame(View v);
        }

        /*Inflates the fragment upon instantiation. */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            FrameLayout gameLayout = (FrameLayout) inflater.inflate(R.layout.activity_game_board, container, false);

            /*Set text for player's score. */
            playerScore = (TextView) gameLayout.findViewById(R.id.player_score);
            playerScore.setText(String.valueOf(player.getScore()));

            /*Set the text of the buttons.  Again, this could be optimized in the future. */
            buttonA = (Button) gameLayout.findViewById(R.id.buttonA);
            //Makes sure not passing a null value, as will be using Integer.parseInt() to
            //get the value of the button.
            if (playerHand[0] != null) {
                buttonA.setText(String.valueOf(String.valueOf(playerHand[0].getValue())));
            }
            else {
                //If null, just set to 0.
                buttonA.setText("0");
            }

            buttonB = (Button) gameLayout.findViewById(R.id.buttonB);
            if (playerHand[1] != null) {
                buttonB.setText(String.valueOf(String.valueOf(playerHand[1].getValue())));
            }
            else {
                buttonB.setText("0");
            }

            buttonC = (Button) gameLayout.findViewById(R.id.buttonC);
            if (playerHand[2] != null) {
                buttonC.setText(String.valueOf(String.valueOf(playerHand[2].getValue())));
            }
            else {
                buttonC.setText("0");
            }

            buttonD = (Button) gameLayout.findViewById(R.id.buttonD);
            if (playerHand[3] != null) {
                buttonD.setText(String.valueOf(String.valueOf(playerHand[3].getValue())));
            }

            else {
                buttonD.setText("0");
            }

            buttonE = (Button) gameLayout.findViewById(R.id.buttonE);
            if (playerHand[4] != null) {
                buttonE.setText(String.valueOf(String.valueOf(playerHand[4].getValue())));
            }
            else {
                buttonE.setText("0");
            }

            buttonF = (Button) gameLayout.findViewById(R.id.buttonF);
            if (playerHand[5] !=null) {
                buttonF.setText(String.valueOf(String.valueOf(playerHand[5].getValue())));
            }
            else {
                buttonF.setText("0");
            }

            return gameLayout;
        }

    /*Makes sure fragment is attached to container properly, otherwise throws an
    exception.
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            game = (GameListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement GameListener");
        }
    }

    /*What to do with fragment once done with it. */
    @Override
    public void onDetach() {
        super.onDetach();
        game = null;
    }
}
