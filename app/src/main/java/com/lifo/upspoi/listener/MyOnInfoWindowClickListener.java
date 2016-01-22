package com.lifo.upspoi.listener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.lifo.upspoi.PhotoActivity;

/**
 * Created by Stav on 22/01/2016.
 */
public class MyOnInfoWindowClickListener implements GoogleMap.OnInfoWindowClickListener {
    Activity act;
    Uri image;

    public MyOnInfoWindowClickListener(Activity act, Uri image) {
        this.act = act;
        this.image = image;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent i = new Intent(act, PhotoActivity.class);
        i.putExtra("bitmapImage", image);
        act.startActivity(i);
    }
}
