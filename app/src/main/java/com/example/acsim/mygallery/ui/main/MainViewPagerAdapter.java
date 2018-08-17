package com.example.acsim.mygallery.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: {
                return new ImageFragment();
            }
            case 1: {
                return new VideoFragment();
            }
            case 2: {
                return new AlbumFragment();
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
