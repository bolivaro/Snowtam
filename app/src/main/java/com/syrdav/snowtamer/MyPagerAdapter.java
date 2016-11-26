package com.syrdav.snowtamer;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 22/11/2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> fragments;
    private String title;

    //On fournit à l'adapter la liste des fragments à afficher
    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments,String title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    public String getPageTitle(int position) {
        return title;
    }
}
