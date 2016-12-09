package com.syrdav.snowtamer;

/**
 * Created by David on 29/11/2016.
 */
public class SnowtamerModel {
    private String data;
    private static final SnowtamerModel snm = new SnowtamerModel();

    public static SnowtamerModel getInstance() {
        return snm;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
