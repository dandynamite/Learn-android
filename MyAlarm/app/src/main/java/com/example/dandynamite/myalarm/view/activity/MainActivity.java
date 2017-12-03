package com.example.dandynamite.myalarm.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.dandynamite.myalarm.R;
import com.example.dandynamite.myalarm.AlarmService;
import com.example.dandynamite.myalarm.external.MyDatabase;
import com.example.dandynamite.myalarm.view.adapter.ViewPagerAdapter;
import com.example.dandynamite.myalarm.view.fragment.AlarmFragment;
import com.example.dandynamite.myalarm.view.fragment.MyFragment;
import com.example.dandynamite.myalarm.view.fragment.StopwatchFragment;
import com.example.dandynamite.myalarm.view.fragment.TimerFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private List<MyFragment> fragmentList;
    private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this,AlarmService.class));
        myDatabase = MyDatabase.getInstance(this);
        myDatabase.open();
        initFragments();
        addComponents();
        addEvents();


    }


    private void addEvents() {

    }
    private void initFragments(){
        fragmentList = new ArrayList<>();
        fragmentList.add(new AlarmFragment());
        fragmentList.add(new StopwatchFragment());
        fragmentList.add(new TimerFragment());
    }

    private void addComponents() {
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);

        mViewPager = (ViewPager) findViewById(R.id.mViewpager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        mTabLayout.setSelectedTabIndicatorHeight(2);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
