/*Class EndGameScreenFragment
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EndGameScreenFragment extends Fragment {
    /*Get player and ai from MainScreenActivity.*/
    Player player = MainScreenActivity.getPlayer();
    AI ai = MainScreenActivity.getAI();

    /*TextViews for ai score, player score, and win/lose message. */
    private static TextView stateMessage;
    private static TextView aiEndScore;
    private static TextView playerEndScore;
    EndListener end;

    /*Interface EndListener. */
    public interface EndListener {
        public void restartGame(View v);
        public void quitEndGame(View v);
    }

    /*Inflates the view of the fragment when called by MainScreenActivity. */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RelativeLayout endLayout = (RelativeLayout) inflater.inflate(R.layout.activity_end_game, container, false);
        //Set the message.
        stateMessage = (TextView) endLayout.findViewById(R.id.gameMessage);
        stateMessage.setText(displayWinMessage());

        //Set player's score to text view.
        playerEndScore = (TextView) endLayout.findViewById(R.id.PlayerNumScore);
        playerEndScore.setText(String.valueOf(player.getScore()));

        //Set ai's score to text view.
        aiEndScore = (TextView) endLayout.findViewById(R.id.AINumScore);
        aiEndScore.setText(String.valueOf(ai.getScore()));


        return endLayout;


    }
    /*Makes sure attached properly, otherwise throws an exception. */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            end = (EndListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement EndListener");
        }
    }

    /*What to do with the fragment when done. */
    @Override
    public void onDetach() {
        super.onDetach();
        end = null;
    }

    /*Displays message based upon scores of players. */
    public String displayWinMessage() {

        String message= "";
        if (player.checkScore() && ai.checkScore()) {
            message = "Both players bust.  Both lose.";
        }
        else if ((player.checkScore() && !ai.checkScore()) ||
                (!player.checkScore() && !ai.checkScore() &&
                        player.getScore() <ai.getScore()))  {
            message = "Computer wins!";
        }
        else if ((!player.checkScore() && ai.checkScore()) ||
                ((!player.checkScore() && !ai.checkScore() &&
                player.getScore() >ai.getScore()))){
            message = "Player 1 wins!";
        }
        else {
            message = "Tie.";
        }
        return message;
    }
}