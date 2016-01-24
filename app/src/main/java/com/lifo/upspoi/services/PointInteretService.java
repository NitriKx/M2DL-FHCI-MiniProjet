package com.lifo.upspoi.services;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.common.collect.Lists;
import com.lifo.upspoi.model.ElementDeCarte;
import com.lifo.upspoi.model.Image;
import com.lifo.upspoi.model.PointInteret;
import com.lifo.upspoi.model.Tag;
import com.lifo.upspoi.model.ZoneRectangulaireInteret;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benoît Sauvère on 21/01/16.
 */
public class PointInteretService {

    public List<Tag> getTagDeclare() {
        return Lists.newArrayList(
                new Tag("recyclage"),
                new Tag("verre"),
                new Tag("carton"),
                new Tag("textile"),
                new Tag("piles"),
                new Tag("papier")
        );
    }

    public List<? extends ElementDeCarte> getElementDeCarteDansZone(Polygon zone) {
        return Lists.newArrayList(
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.55891,1.47303)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.55999,1.47194)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.55995,1.47195)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56439,1.47053)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56355,1.47579)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.55509,1.46816)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56295,1.46311)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56305,1.45939)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56068,1.45738)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56376,1.45531)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56850,1.46620)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56735,1.46726)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.57124,1.46269)),
                new PointInteret("verre", Lists.newArrayList(new Tag("recyclage"), new Tag("verre")), new Image("", null), new LatLng(43.56731,1.46477)),

                new PointInteret("textile", Lists.newArrayList(new Tag("recyclage"), new Tag("textile")), new Image("", null), new LatLng(43.55505,1.46811)),
                new PointInteret("textile", Lists.newArrayList(new Tag("recyclage"), new Tag("textile")), new Image("", null), new LatLng(43.56305,1.45935)),

                new ZoneRectangulaireInteret("carton", Lists.newArrayList(new Tag("recyclage"), new Tag("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.55773,1.46920), new LatLng(43.55780,1.46934), new LatLng(43.55745,1.46969), new LatLng(43.55738,1.46954))),
                new ZoneRectangulaireInteret("carton", Lists.newArrayList(new Tag("recyclage"), new Tag("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.55992,1.47172), new LatLng(43.56000,1.47186), new LatLng(43.55948,1.47236), new LatLng(43.55942,1.47220))),
                new ZoneRectangulaireInteret("carton", Lists.newArrayList(new Tag("recyclage"), new Tag("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.5622,1.46751), new LatLng(43.56231,1.4677), new LatLng(43.56206,1.46795), new LatLng(43.56197,1.46772))),
                new ZoneRectangulaireInteret("carton", Lists.newArrayList(new Tag("recyclage"), new Tag("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.56449,1.4656), new LatLng(43.56455,1.46576), new LatLng(43.56406,1.46625), new LatLng(43.56398,1.46609))),
                new ZoneRectangulaireInteret("carton", Lists.newArrayList(new Tag("recyclage"), new Tag("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.56577,1.46736), new LatLng(43.56593,1.46769), new LatLng(43.56577,1.46785), new LatLng(43.5656,1.46753))),
                new ZoneRectangulaireInteret("carton", Lists.newArrayList(new Tag("recyclage"), new Tag("carton")), new Image("", null), Lists.newArrayList(new LatLng(43.56665,1.4695), new LatLng(43.56674,1.46968), new LatLng(43.56657,1.46985), new LatLng(43.5665,1.46965))),

                new ZoneRectangulaireInteret("pile", Lists.newArrayList(new Tag("recyclage"), new Tag("pile")), new Image("", null), Lists.newArrayList(new LatLng(43.56362,1.46487), new LatLng(43.56381,1.46537), new LatLng(43.56354,1.4657), new LatLng(43.5633,1.46522))),
                new ZoneRectangulaireInteret("pile", Lists.newArrayList(new Tag("recyclage"), new Tag("pile")), new Image("", null), Lists.newArrayList(new LatLng(43.56456,1.46589), new LatLng(43.56472,1.46617), new LatLng(43.56458,1.46629), new LatLng(43.56446,1.46602))),

                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56758,1.46950), new LatLng(43.56773,1.46989), new LatLng(43.56733,1.47026), new LatLng(43.56716,1.46991))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56666,1.46950), new LatLng(43.56674,1.46967), new LatLng(43.56667,1.46975), new LatLng(43.56657,1.46958))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56497,1.46513), new LatLng(43.56504,1.46529), new LatLng(43.56461,1.4657), new LatLng(43.56454,1.46554))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56542,1.46363), new LatLng(43.56554,1.4639), new LatLng(43.5652,1.46422), new LatLng(43.56508,1.46391))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56372,1.46478), new LatLng(43.56393,1.46529), new LatLng(43.56426,1.46496), new LatLng(43.56403,1.46448))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56349,1.46428), new LatLng(43.56362,1.4646), new LatLng(43.56323,1.46499), new LatLng(43.56311,1.46473))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.5632,1.465620), new LatLng(43.56335,1.4659), new LatLng(43.56263,1.46661), new LatLng(43.56249,1.46632))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56377,1.46168), new LatLng(43.56384,1.46181), new LatLng(43.56375,1.46195), new LatLng(43.56367,1.4618))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56123,1.46364), new LatLng(43.56137,1.46392), new LatLng(43.56086,1.46442), new LatLng(43.56072,1.46414))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56151,1.46595), new LatLng(43.56161,1.46623), new LatLng(43.56186,1.46599), new LatLng(43.56175,1.46571))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56146,1.46600), new LatLng(43.56154,1.46615), new LatLng(43.56112,1.46656), new LatLng(43.56104,1.46641))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56202,1.46603), new LatLng(43.5621,1.46618), new LatLng(43.5615,1.46678), new LatLng(43.56142,1.46663))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56146,1.46709), new LatLng(43.56156,1.4673), new LatLng(43.5614,1.46745), new LatLng(43.5613,1.46725))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56245,1.4669), new LatLng(43.56253,1.46706), new LatLng(43.5623,1.46728), new LatLng(43.56222,1.46713))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.5618,1.4677), new LatLng(43.56197,1.46805), new LatLng(43.56174,1.46827), new LatLng(43.56157,1.46793) )),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56263,1.46908), new LatLng(43.56277,1.46939), new LatLng(43.5625,1.46965), new LatLng(43.56236,1.46932))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56189,1.46903), new LatLng(43.56201,1.4693), new LatLng(43.56185,1.46944), new LatLng(43.56173,1.46916))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56134,1.46839), new LatLng(43.56141,1.46855), new LatLng(43.56101,1.46896), new LatLng(43.56093,1.46881))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56141,1.46894), new LatLng(43.56169,1.46951), new LatLng(43.56105,1.47007), new LatLng(43.56079,1.46955))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56153,1.47001), new LatLng(43.56088,1.47064), new LatLng(43.56107,1.47108), new LatLng(43.56173,1.47041))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.55933,1.47231), new LatLng(43.55939,1.47246), new LatLng(43.55886,1.47299), new LatLng(43.55879,1.47284))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56076,1.46724), new LatLng(43.56084,1.46739), new LatLng(43.55942,1.46883), new LatLng(43.55934,1.46868))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.56025,1.46732), new LatLng(43.56032,1.46748), new LatLng(43.55976,1.46805), new LatLng(43.55968,1.46787))),
                new ZoneRectangulaireInteret("papier", Lists.newArrayList(new Tag("recyclage"), new Tag("papier")), new Image("", null), Lists.newArrayList(new LatLng(43.55844,1.46891), new LatLng(43.55852,1.46906), new LatLng(43.55798,1.4696), new LatLng(43.5579,1.46945)))
        );
    }

    public List<LatLng> getDelimitationFac() {
        List<LatLng> delimitationFac = new ArrayList<LatLng>();

        delimitationFac.add(new LatLng(43.561269,1.462641));
        delimitationFac.add(new LatLng(43.559978,1.463370));
        delimitationFac.add(new LatLng(43.558361,1.464357));
        delimitationFac.add(new LatLng(43.556137,1.466074));
        delimitationFac.add(new LatLng(43.555919,1.466331));
        delimitationFac.add(new LatLng(43.555313,1.467297));
        delimitationFac.add(new LatLng(43.554396,1.469142));
        delimitationFac.add(new LatLng(43.554131,1.471074));
        delimitationFac.add(new LatLng(43.554084,1.471610));
        delimitationFac.add(new LatLng(43.554675,1.472104));
        delimitationFac.add(new LatLng(43.555204,1.472511));
        delimitationFac.add(new LatLng(43.555671,1.473434));
        delimitationFac.add(new LatLng(43.555982,1.473927));
        delimitationFac.add(new LatLng(43.556417,1.474764));
        delimitationFac.add(new LatLng(43.557132,1.475987));
        delimitationFac.add(new LatLng(43.557319,1.477532));
        delimitationFac.add(new LatLng(43.557459,1.479335));
        delimitationFac.add(new LatLng(43.558213,1.478434));
        delimitationFac.add(new LatLng(43.559659,1.476513));
        delimitationFac.add(new LatLng(43.561331,1.474743));
        delimitationFac.add(new LatLng(43.562925,1.472543));
        delimitationFac.add(new LatLng(43.563500,1.471953));
        delimitationFac.add(new LatLng(43.564091,1.471696));
        delimitationFac.add(new LatLng(43.565210,1.471707));
        delimitationFac.add(new LatLng(43.565436,1.472468));
        delimitationFac.add(new LatLng(43.564689,1.473885));
        delimitationFac.add(new LatLng(43.563508,1.475086));
        delimitationFac.add(new LatLng(43.563134,1.475472));
        delimitationFac.add(new LatLng(43.564783,1.478992));
        delimitationFac.add(new LatLng(43.562264,1.481395));
        delimitationFac.add(new LatLng(43.562481,1.483197));
        delimitationFac.add(new LatLng(43.562544,1.484356));
        delimitationFac.add(new LatLng(43.563414,1.486459));
        delimitationFac.add(new LatLng(43.566897,1.482210));
        delimitationFac.add(new LatLng(43.568980,1.478863));
        delimitationFac.add(new LatLng(43.570535,1.476073));
        delimitationFac.add(new LatLng(43.570846,1.474743));
        delimitationFac.add(new LatLng(43.571281,1.474142));
        delimitationFac.add(new LatLng(43.572587,1.472683));
        delimitationFac.add(new LatLng(43.573240,1.471438));
        delimitationFac.add(new LatLng(43.572991,1.470108));
        delimitationFac.add(new LatLng(43.574142,1.469293));
        delimitationFac.add(new LatLng(43.574111,1.468005));
        delimitationFac.add(new LatLng(43.573738,1.466675));
        delimitationFac.add(new LatLng(43.573054,1.465516));
        delimitationFac.add(new LatLng(43.572307,1.464100));
        delimitationFac.add(new LatLng(43.571872,1.462727));
        delimitationFac.add(new LatLng(43.571841,1.461825));
        delimitationFac.add(new LatLng(43.571592,1.462297));
        delimitationFac.add(new LatLng(43.570970,1.463585));
        delimitationFac.add(new LatLng(43.570566,1.464100));
        delimitationFac.add(new LatLng(43.569478,1.464272));
        delimitationFac.add(new LatLng(43.568359,1.464443));
        delimitationFac.add(new LatLng(43.567799,1.464443));
        delimitationFac.add(new LatLng(43.567830,1.463628));
        delimitationFac.add(new LatLng(43.567892,1.462598));
        delimitationFac.add(new LatLng(43.567892,1.461825));
        delimitationFac.add(new LatLng(43.567612,1.461139));
        delimitationFac.add(new LatLng(43.567395,1.460581));
        delimitationFac.add(new LatLng(43.568048,1.459937));
        delimitationFac.add(new LatLng(43.566959,1.458650));
        delimitationFac.add(new LatLng(43.566368,1.458993));
        delimitationFac.add(new LatLng(43.564658,1.455946));
        delimitationFac.add(new LatLng(43.563881,1.456504));
        delimitationFac.add(new LatLng(43.563694,1.456375));
        delimitationFac.add(new LatLng(43.563274,1.456890));
        delimitationFac.add(new LatLng(43.564969,1.459851));
        delimitationFac.add(new LatLng(43.564285,1.460409));
        delimitationFac.add(new LatLng(43.561922,1.456568));
        delimitationFac.add(new LatLng(43.560149,1.457469));
        delimitationFac.add(new LatLng(43.561502,1.458242));
        delimitationFac.add(new LatLng(43.562093,1.459122));
        delimitationFac.add(new LatLng(43.563414,1.460667));
        delimitationFac.add(new LatLng(43.563787,1.461375));
        delimitationFac.add(new LatLng(43.561269,1.462668));

        return delimitationFac;
    }

    //
    //  SINGLETON
    //

    private static final PointInteretService __instance = new PointInteretService();

    private PointInteretService() {}

    public static PointInteretService getInstance() {
        return __instance;
    }

}
