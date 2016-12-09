package com.syrdav.snowtamer;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by David on 05/12/2016.
 */
public class Localisation extends AsyncTask<String,Void, String>{
    @Override
    protected String doInBackground(String... strings) {
        StringBuffer buffer = new StringBuffer();
        try {
            Log.d("JSwa", "Connecting to ["+strings[0]+"]");
            Document doc = Jsoup.connect(strings[0]).get();
            Log.d("JSwa", "Connected to ["+strings[0]+"]");

            String title = doc.title();
            String lat = doc.getElementsByAttributeValue("data-key","latitude").text();
            String longi = doc.getElementsByAttributeValue("data-key","longitude").text();
            buffer.append(title);
            buffer.append("/"+lat);
            buffer.append("/"+longi);
            Log.d("bufferasync", "doInBackground: " +buffer.toString());
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        return buffer.toString();
    }
}
