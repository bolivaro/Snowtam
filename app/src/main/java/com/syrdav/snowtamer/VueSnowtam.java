package com.syrdav.snowtamer;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class VueSnowtam extends AppCompatActivity {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types and number of parameters
    private PagerAdapter mPagerAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_vue_snowtam);

        ArrayList<Fragment> fragments = new ArrayList();


        fragments.add(Fragment.instantiate(this,PremierSnow.class.getName()));
        fragments.add(Fragment.instantiate(this,SecondSnow.class.getName()));
        fragments.add(Fragment.instantiate(this,TroisiemeSnow.class.getName()));

        this.mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments, getResources().getString(R.string.app_name));

        ViewPager pager = (ViewPager) super.findViewById(R.id.framevuesnow);
        // Affectation de l'adapter au ViewPager
        pager.setAdapter(this.mPagerAdapter);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


}

