package com.lifo.upspoi.Utils;

/**
 * Created by Stav on 22/01/2016.
 */
public class Color {
    private int rouge;
    private int vert;
    private int bleu;

    public Color(int r, int v, int b) {
        rouge=r;
        vert=v;
        bleu=b;
    }

    public int getRouge(){
        return rouge;
    }

    public int getVert() {
        return vert;
    }
    public int getBleu() {
        return bleu;
    }
    public float getHue() {
        int rgbaColor = android.graphics.Color.argb(255, rouge, vert, bleu);
        float[] hsv = {0f,0f,0f};
        android.graphics.Color.colorToHSV(rgbaColor,hsv);
        return hsv[0];
    }
    public int getIntCouleur() {
        return android.graphics.Color.rgb(rouge, vert, bleu);
    }
}
