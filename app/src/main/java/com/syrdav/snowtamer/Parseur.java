package com.syrdav.snowtamer;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by David on 30/11/2016.
 */
public class Parseur extends AsyncTask <String, Void, String>{

    @Override
    protected String doInBackground(String... strings) {
        StringBuffer buffer = new StringBuffer();
        try {
            Log.d("JSwa", "Connecting to ["+strings[0]+"]");
            Document doc = Jsoup.connect(strings[0]).get();
            Log.d("JSwa", "Connected to ["+strings[0]+"]");

            Elements topicList = doc.select("PRE");

            int i =0;
            boolean isSnow = false;
            String data;
            do{
                Element topic = topicList.get(i);
                data = topic.text();
                if(data.contains("SNOWTAM")){
                    buffer.append(data);
                    isSnow = true;
                }
                i++;
            }while((!isSnow)&&(i<topicList.size()));
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        return buffer.toString();

    }
}
