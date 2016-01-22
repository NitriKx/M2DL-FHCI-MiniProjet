package com.lifo.upspoi.listener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.lifo.upspoi.PhotoActivity;

/**
 * Created by Stav on 21/01/2016.
 */
public class MyOnMarkerClickListener implements GoogleMap.OnMarkerClickListener {

    Activity act;
    Uri image;

    public MyOnMarkerClickListener(Activity act, Uri image) {
        this.act = act;
        this.image = image;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent i = new Intent(act, PhotoActivity.class);
        i.putExtra("bitmapImage", image);
        act.startActivity(i);

        return true;
    }
}
