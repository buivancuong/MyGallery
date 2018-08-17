package com.example.acsim.mygallery.ui.main;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.acsim.mygallery.R;

public class MainActivity extends FragmentActivity {

    ActionBar mainActionBar;
    String tabItem[] = {"Image", "Video", "Album"};

    ViewPager mainViewPager;
    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActionBar = getActionBar();
        assert mainActionBar != null;
        mainActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mainViewPager = findViewById(R.id.mainViewPager);
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainViewPagerAdapter);

        mainViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {

                getActionBar().setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

                mainViewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }
        };

        for (String aTabItem : tabItem) {
            mainActionBar.addTab(mainActionBar.newTab().setText(aTabItem).setTabListener(tabListener));
        }

    }
}
