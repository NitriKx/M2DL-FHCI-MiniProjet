package com.lifo.upspoi.listener;

import android.view.View;
import android.widget.AdapterView;

import com.lifo.upspoi.MainActivity;

/**
 * Created by Stav on 24/01/2016.
 */
public class MyOnItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {

    private MainActivity act;

    public MyOnItemSelectedListener(MainActivity act) {
        this.act = act;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String filtre = parent.getItemAtPosition(position).toString();
        if (filtre.equals("Tous")) {
            filtre = null;
        }
        act.afficherPOI(filtre);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
