package com.lifo.upspoi.Utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lifo.upspoi.model.PointTag;

import java.util.List;

/**
 * Created by Stav on 24/01/2016.
 */
public class MySpinnerAdapter extends ArrayAdapter<String> {
    private List<PointTag> tags;

    public MySpinnerAdapter(Context context, List<String> items, List<PointTag> tags)
    {
        super(context, android.R.layout.simple_spinner_item, items);
        this.tags = tags;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        View view = super.getDropDownView(position, convertView, parent);
        applyColor(view, position);
        return view;
    }

    private void applyColor(View view, int position)
    {
        TextView text = (TextView) view.findViewById(android.R.id.text1);
        text.setTextSize(25f);
        text.setPadding(5,5,5,5);
        if (position == 0) {
            text.setTextColor(Color.BLACK);
        } else {
            if (tags.get(position-1).getCouleur() != null) {
                text.setTextColor(tags.get(position-1).getCouleur().getIntCouleur());
            }
        }
    }
}
