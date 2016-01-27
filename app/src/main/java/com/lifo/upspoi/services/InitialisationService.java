package com.lifo.upspoi.services;

import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.common.collect.Lists;
import com.lifo.upspoi.Utils.Color;
import com.lifo.upspoi.model.ElementDeCarte;
import com.lifo.upspoi.model.Image;
import com.lifo.upspoi.model.PointTag;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;
import java.util.Map;

/**
 * Created by Benoît Sauvère on 22/01/16.
 */
public class InitialisationService {

    //
    //
    //   PUBLIC
    //
    //


    /**
     *
     */
    public void initialiserBaseSiBesoin() {
        if (isBaseInitialisee() == false) {
            Log.i("INIT", "Initialisation de la base de données...");
            resetDatabase();
        }
    }

    /**
     *
     */
    public void resetDatabase() {
        clearDatabase();
        initialiserTags();
        initialiserBaseMarqueur();
    }


    //
    //
    //   PRIVATE
    //
    //

    private void clearDatabase() {
        Log.i("INIT", "Suppression des données de la base...");
        try {
            SQLite.delete(Image.class).execute();
        } catch (SQLiteException e) {
            Log.i("INIT", "Impossible de supprimer la table Image car n'existe pas");
        }

        try {
            SQLite.delete(ElementDeCarte.class).execute();
        } catch (SQLiteException e) {
            Log.i("INIT", "Impossible de supprimer la table ElementDeCarte car n'existe pas");
        }

        try {
            SQLite.delete(PointTag.class).execute();
        } catch (SQLiteException e) {
            Log.i("INIT", "Impossible de supprimer la table PointTag car n'existe pas");
        }

    }

    /**
     *
     */
    private boolean isBaseInitialisee() {
        try {
            return SQLite.selectCountOf().from(ElementDeCarte.class).count() > 0;
        } catch (SQLiteException e) {
            Log.i("INIT", "La table ElementDeCarte n'existe pas, on considère donc que la base n'a pas été initialisée");
            return false;
        }
    }

    /**
     *
     */
    private void initialiserTags() {
        List<PointTag> listeTags = Lists.newArrayList(
                new PointTag("recyclage"),
                new PointTag("verre", new Color(0, 255, 0)),
                new PointTag("carton", new Color(255, 153, 51)),
                new PointTag("textile", new Color(255, 0, 255)),
                new PointTag("piles", new Color(178, 102, 255)),
                new PointTag("papier", new Color(0, 255, 255))
        );

        Log.i("INIT", String.format("Initialisation de la liste de tags (%d éléments)...", listeTags.size()));

        for (PointTag t : listeTags) {
            t.save();
        }
    }

    /**
     *
     */
    private void initialiserBaseMarqueur() {

        // Récupère la liste des tags afin de garder des références communes
        Map<String, PointTag> listeTag = PointInteretService.getInstance().getTagsDeclare();

        List<ElementDeCarte> elementsRecyclagePaulSabatier = Lists.newArrayList(
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.55891, 1.47303)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.55999, 1.47194)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.55995, 1.47195)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56439, 1.47053)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56355, 1.47579)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.55509, 1.46816)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56295, 1.46311)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56305, 1.45939)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56068, 1.45738)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56376, 1.45531)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56850, 1.46620)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56735, 1.46726)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.57124, 1.46269)),
                new ElementDeCarte("verre", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("verre")), new Image("", null), new LatLng(43.56731, 1.46477)),

                new ElementDeCarte("textile", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("textile")), new Image("", null), new LatLng(43.55505, 1.46811)),
                new ElementDeCarte("textile", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("textile")), new Image("", null), new LatLng(43.56305, 1.45935)),

                new ElementDeCarte("carton", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.55773, 1.46920), new LatLng(43.55780, 1.46934), new LatLng(43.55745, 1.46969), new LatLng(43.55738, 1.46954))),
                new ElementDeCarte("carton", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.55992, 1.47172), new LatLng(43.56000, 1.47186), new LatLng(43.55948, 1.47236), new LatLng(43.55942, 1.47220))),
                new ElementDeCarte("carton", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.5622, 1.46751), new LatLng(43.56231, 1.4677), new LatLng(43.56206, 1.46795), new LatLng(43.56197, 1.46772))),
                new ElementDeCarte("carton", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.56449, 1.4656), new LatLng(43.56455, 1.46576), new LatLng(43.56406, 1.46625), new LatLng(43.56398, 1.46609))),
                new ElementDeCarte("carton", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.56577, 1.46736), new LatLng(43.56593, 1.46769), new LatLng(43.56577, 1.46785), new LatLng(43.5656, 1.46753))),
                new ElementDeCarte("carton", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.56665, 1.4695), new LatLng(43.56674, 1.46968), new LatLng(43.56657, 1.46985), new LatLng(43.5665, 1.46965))),

                new ElementDeCarte("pile", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("pile")), new Image("", null), Lists.newArrayList(new LatLng(43.56362, 1.46487), new LatLng(43.56381, 1.46537), new LatLng(43.56354, 1.4657), new LatLng(43.5633, 1.46522))),
                new ElementDeCarte("pile", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("pile")), new Image("", null), Lists.newArrayList(new LatLng(43.56456, 1.46589), new LatLng(43.56472, 1.46617), new LatLng(43.56458, 1.46629), new LatLng(43.56446, 1.46602))),

                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56758, 1.46950), new LatLng(43.56773, 1.46989), new LatLng(43.56733, 1.47026), new LatLng(43.56716, 1.46991))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56666, 1.46950), new LatLng(43.56674, 1.46967), new LatLng(43.56667, 1.46975), new LatLng(43.56657, 1.46958))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56497, 1.46513), new LatLng(43.56504, 1.46529), new LatLng(43.56461, 1.4657), new LatLng(43.56454, 1.46554))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56542, 1.46363), new LatLng(43.56554, 1.4639), new LatLng(43.5652, 1.46422), new LatLng(43.56508, 1.46391))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56372, 1.46478), new LatLng(43.56393, 1.46529), new LatLng(43.56426, 1.46496), new LatLng(43.56403, 1.46448))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56349, 1.46428), new LatLng(43.56362, 1.4646), new LatLng(43.56323, 1.46499), new LatLng(43.56311, 1.46473))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.5632, 1.465620), new LatLng(43.56335, 1.4659), new LatLng(43.56263, 1.46661), new LatLng(43.56249, 1.46632))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56377, 1.46168), new LatLng(43.56384, 1.46181), new LatLng(43.56375, 1.46195), new LatLng(43.56367, 1.4618))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56123, 1.46364), new LatLng(43.56137, 1.46392), new LatLng(43.56086, 1.46442), new LatLng(43.56072, 1.46414))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56151, 1.46595), new LatLng(43.56161, 1.46623), new LatLng(43.56186, 1.46599), new LatLng(43.56175, 1.46571))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56146, 1.46600), new LatLng(43.56154, 1.46615), new LatLng(43.56112, 1.46656), new LatLng(43.56104, 1.46641))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56202, 1.46603), new LatLng(43.5621, 1.46618), new LatLng(43.5615, 1.46678), new LatLng(43.56142, 1.46663))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56146, 1.46709), new LatLng(43.56156, 1.4673), new LatLng(43.5614, 1.46745), new LatLng(43.5613, 1.46725))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56245, 1.4669), new LatLng(43.56253, 1.46706), new LatLng(43.5623, 1.46728), new LatLng(43.56222, 1.46713))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.5618, 1.4677), new LatLng(43.56197, 1.46805), new LatLng(43.56174, 1.46827), new LatLng(43.56157, 1.46793))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56263, 1.46908), new LatLng(43.56277, 1.46939), new LatLng(43.5625, 1.46965), new LatLng(43.56236, 1.46932))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56189, 1.46903), new LatLng(43.56201, 1.4693), new LatLng(43.56185, 1.46944), new LatLng(43.56173, 1.46916))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56134, 1.46839), new LatLng(43.56141, 1.46855), new LatLng(43.56101, 1.46896), new LatLng(43.56093, 1.46881))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56141, 1.46894), new LatLng(43.56169, 1.46951), new LatLng(43.56105, 1.47007), new LatLng(43.56079, 1.46955))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56153, 1.47001), new LatLng(43.56088, 1.47064), new LatLng(43.56107, 1.47108), new LatLng(43.56173, 1.47041))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.55933, 1.47231), new LatLng(43.55939, 1.47246), new LatLng(43.55886, 1.47299), new LatLng(43.55879, 1.47284))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56076, 1.46724), new LatLng(43.56084, 1.46739), new LatLng(43.55942, 1.46883), new LatLng(43.55934, 1.46868))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56025, 1.46732), new LatLng(43.56032, 1.46748), new LatLng(43.55976, 1.46805), new LatLng(43.55968, 1.46787))),
                new ElementDeCarte("papier", Lists.newArrayList(listeTag.get("recyclage"), listeTag.get("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.55844, 1.46891), new LatLng(43.55852, 1.46906), new LatLng(43.55798, 1.4696), new LatLng(43.5579, 1.46945)))
        );

        Log.i("INIT", String.format("Initialisation de la liste de éléments de carte (%d éléments)...", elementsRecyclagePaulSabatier.size()));

        for (ElementDeCarte c : elementsRecyclagePaulSabatier) {
            c.save();
        }

    }


    //
    //  SINGLETON
    //

    private static final InitialisationService __instance = new InitialisationService();

    private InitialisationService() {}

    public static InitialisationService getInstance() {
        return __instance;
    }
}
