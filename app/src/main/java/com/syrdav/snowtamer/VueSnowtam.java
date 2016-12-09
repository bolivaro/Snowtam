package com.syrdav.snowtamer;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;


public class VueSnowtam extends AppCompatActivity {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types and number of parameters
    private MyPagerAdapter  mPagerAdapter;
    ArrayList<Fragment> fragments = null;
    Intent asksnowIntent = null;
    String firstsnow="";
    String lien1 = "";
    String lien2 = "";
    String lien3 = "";
    String oaci1 = "";
    String oaci2 = "";
    String oaci3 = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_vue_snowtam);
        asksnowIntent = getIntent();


        Log.d("oaci", "onCreate: "+oaci1);

        fragments = new ArrayList();


        Log.d("oaci1", "onCreate: " +oaci1);
        oaci1 += asksnowIntent.getStringExtra("OACI1");
        lien1 +=asksnowIntent.getStringExtra("lien1");



        if(!oaci1.equals("null")){
            fragments.add(Fragment.instantiate(this,PremierSnow.class.getName()));
            PremierSnow ps1 =(PremierSnow) fragments.get(0);
            ps1.setLien(lien1);
            ps1.setOaci(oaci1);
        }


        Log.d("oaci2", "onCreate: " +oaci2);
        oaci2 += asksnowIntent.getStringExtra("OACI2");
        lien2 += asksnowIntent.getStringExtra("lien2");
        Log.d("oaci2deplus", "onCreate: " +oaci2);

        if(!oaci2.equals("null")){
            fragments.add(Fragment.instantiate(this,SecondSnow.class.getName()));
            SecondSnow ss =(SecondSnow) fragments.get(1);
            ss.setLien(lien2);
            ss.setOaci(oaci2);
        }

        Log.d("oaci3", "onCreate: " +oaci3);
        oaci3 += asksnowIntent.getStringExtra("OACI3");
        lien3 += asksnowIntent.getStringExtra("lien3");

        if(!oaci3.equals("null")){
            fragments.add(Fragment.instantiate(this,TroisiemeSnow.class.getName()));
            TroisiemeSnow ts =(TroisiemeSnow) fragments.get(2);
            ts.setLien(lien3);
            ts.setOaci(oaci3);
        }

        this.mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments, getResources().getString(R.string.app_name));
        //PremierSnow ps = (PremierSnow) mPagerAdapter.getItem(0) ;

        ViewPager pager = (ViewPager) super.findViewById(R.id.framevuesnow);
        // Affectation de l'adapter au ViewPager
        pager.setAdapter(this.mPagerAdapter);
        //ps.setText(firstsnow);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


}

