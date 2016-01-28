package com.lifo.upspoi.listener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.lifo.upspoi.PhotoActivity;
import com.lifo.upspoi.services.PointInteretService;

import java.net.URI;

/**
 * Created by Stav on 22/01/2016.
 *
 * @author Stav, Benoît Sauvère
 */
public class MyOnInfoWindowClickListener implements GoogleMap.OnInfoWindowClickListener {
    private Activity act;

    public MyOnInfoWindowClickListener(Activity act) {
        this.act = act;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        String markerTitle = marker.getTitle();
        String[] splitterTitle = markerTitle.split(" - ");

        if (splitterTitle.length > 1) {
            // Si le split retourne plus d'un élément cela signifie que le marker a un identifiant dans sa partie gauche
            int markerId = Integer.parseInt(splitterTitle[0]);

            // On récupère l'URI de l'image associée
            URI photoURLForMarkerId = PointInteretService.getInstance().getPhotoURLForMarkerId(markerId);

            Intent i = new Intent(act, PhotoActivity.class);
            i.putExtra("bitmapImage", photoURLForMarkerId);
            act.startActivity(i);

        } else {
            // Sinon on ne fait rien
        }

    }
}
