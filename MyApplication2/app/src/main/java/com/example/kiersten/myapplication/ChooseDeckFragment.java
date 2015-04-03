/*Class ChooseDeckFragment
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

public class ChooseDeckFragment extends Fragment {

    ChooseDeckListener choose;

    /*Interface ChooseDeckListener. */
    public interface ChooseDeckListener {
        public void drawMain(View v);
        public void drawPersonal(View v);
    }

    /*Inflates the layout for the fragment upon instantiation.*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_choose_deck, container, false);
    }

    /*Makes sure fragment is attached to container correctly, and if not,
    and exception is thrown. */
   @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            choose = (ChooseDeckListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ChooseDeckListener");
        }
    }
    /*Detach from container. */
    @Override
    public void onDetach() {
        super.onDetach();
        choose = null;
    }
}