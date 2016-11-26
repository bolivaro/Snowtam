package com.syrdav.snowtamer;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class VueSnow extends AppCompatActivity {

    private PagerAdapter mPagerAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_vue_snowtam);

        ArrayList<Fragment> fragments = new ArrayList();


        fragments.add(Fragment.instantiate(this,PremierSnow.class.getName()));
        fragments.add(Fragment.instantiate(this,SecondSnow.class.getName()));
        fragments.add(Fragment.instantiate(this,TroisiemeSnow.class.getName()));

        this.mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments,getResources().getString(R.string.app_name));

        ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
        // Affectation de l'adapter au ViewPager
        pager.setAdapter(this.mPagerAdapter);

    }

}
