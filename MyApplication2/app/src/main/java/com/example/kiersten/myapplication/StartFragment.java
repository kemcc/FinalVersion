/*Class StartFragment
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

public class StartFragment extends Fragment {
    StartListener start;

    /*Interface StartListener. */
    public interface StartListener {
        public void startGame(View v);
        public void readRules(View v);
        public void quitGame(View v);
    }

    /*Makes sure fragment attached to container correctly, otherwise
    raises an exception.
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            start = (StartListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement StartListener");
        }
    }
    /*What to do with fragment when done. */
    @Override
    public void onDetach() {
        super.onDetach();
        start = null;
    }

   // @Override
  //  public void onCreate(Bundle savedInstanceState) {
   //     super.onCreate(savedInstanceState);
  //  }

    /*Inflate layout for fragment. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_start, container, false);
    }

}
