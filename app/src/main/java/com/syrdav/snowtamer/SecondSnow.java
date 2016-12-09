package com.syrdav.snowtamer;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * Created by David on 22/11/2016.
 */
public class SecondSnow extends Fragment implements View.OnClickListener{

    protected View mView;
    TextView textView;
    Button trans = null;
    Button map = null;
    String lien2 = null;
    String oaci2 = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){
        mView = inflater.inflate(R.layout.snowtam1,container, false);
        textView = (TextView) mView.findViewById(R.id.showsnowTview);
        trans = (Button)mView.findViewById(R.id.transButton);
        map = (Button)mView.findViewById(R.id.mapButton);
        map.setOnClickListener(this);

        if(!oaci2.equals("")){
            try {
                textView.setText((new Parseur()).execute(new String[]{lien2}).get());
                if(textView.getText().toString().equals("")){
                    textView.setText("NO SNOWTAM FOUND!!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return mView;
    }

    public void setText(String text){
        Log.d("setText", "setText: ");
        //TextView textView = (TextView) mView.findViewById(R.id.showsnowTview);
        textView.setText(text);
    }

    public String getLien() {
        return lien2;
    }

    public void setLien(String lien) {
        this.lien2 = lien;
    }

    public String getOaci() {
        return oaci2;
    }

    public void setOaci(String oaci) {
        this.oaci2 = oaci;
    }

    @Override
    public void onClick(View v) {
        if(!oaci2.equals("")){
            String url ="https://www.world-airport-codes.com/search?s="+this.getOaci();
            String coord=null;
            try {
                coord = (new Localisation()).execute(new String[] {url}).get();

                if(!coord.equals("")){
                    Log.d("cordonnee", "coordonnees :" +coord);
                    Intent versmap = new Intent(this.getContext(), MapsActivity.class);
                    versmap.putExtra("coord",coord);
                    startActivity(versmap);
                }else{
                    Toast toast = Toast.makeText(this.getContext(),"No place found", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


    }
}
