package com.adit.calvolume.util;

public class BalokIndex {
    private int tinggi;
    private int panjang;
    private int lebar;
    private float index;

    public BalokIndex(int tinggi, int panjang, int lebar) {
        this.tinggi = tinggi;
        this.panjang = panjang;
        this.lebar = lebar;
        this.index = calculate();
    }

    public float getIndex() {

        return index;
    }

    public float calculate() {

        return tinggi * panjang * lebar;
    }
}

