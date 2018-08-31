//package com.example.acsim.mygallery.ui.main;
//
////Adapter này kiểm soát quá trình đổ Fragment tương ứng với tên của Tab vào
////ViewPager trong Main Activity.
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentStatePagerAdapter;
//
//import com.example.acsim.mygallery.ui.main.image.ImageFragment;
//import com.example.acsim.mygallery.ui.main.video.VideoFragment;
//
//public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
//    MainViewPagerAdapter(FragmentManager fm) {
//        super(fm);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//
//        switch (position) {
//            case 0: {
//                return new ImageFragment();
//            }
//            case 1: {
//                return new VideoFragment();
//            }
//            case 2: {
//                return new AlbumFragment();
//            }
//        }
//
//        return null;
//    }
//
//    @Override
//    public int getCount() {
//        return 3;
//    }
//}
