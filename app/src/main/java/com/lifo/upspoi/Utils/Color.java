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
}
