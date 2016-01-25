package com.lifo.upspoi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lifo.upspoi.model.ElementDeCarte;
import com.lifo.upspoi.services.PointInteretService;

import java.util.List;

/**
 * Created by Benoît Sauvère on 22/01/16.
 */
public class DatabaseDebugActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView t = new TextView(this);

        List<? extends ElementDeCarte> pois = PointInteretService.getInstance().getElementDeCarteDansZone(null);
        for (ElementDeCarte poi : pois) {
            t.append("ElementDeCarte - " + poi.toString());
        }

        setContentView(t);
    }
}
