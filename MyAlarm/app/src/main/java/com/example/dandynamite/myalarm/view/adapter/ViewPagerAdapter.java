package com.example.dandynamite.myalarm.view.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dandynamite.myalarm.view.fragment.MyFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<MyFragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<MyFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getName();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return (fragments == null)? 0:fragments.size();
    }
}