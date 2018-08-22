package com.example.acsim.mygallery.ui.main;

//Main Activity sẽ chứa 1 ViewPager được kết nối tương tác với các Tab để chuyển đổi qua lại
//giữa các Fragment trong ViewPager.
//ViewPager chứa các Fragment là một thành phần chứa trong nó nội dung của các tệp tin media có
//trong thiết bị, được phân loại theo tên các Tab {Image, Video, Album}
//Để đổ dữ liệu từ các Fragment vào ViewPager để hiển thị lên Main Activity, ta cần sử dụng
// MainViewPagerAdapter là 1 adapter lấy dữ liệu từ các Fragment tương ứng.

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.acsim.mygallery.R;
import com.example.acsim.mygallery.model.Album;
import com.example.acsim.mygallery.model.Image;
import com.example.acsim.mygallery.model.Video;

import java.util.List;

public class MainActivity extends FragmentActivity implements MainContractor.View, ImageAdapter.ClickListener, VideoAdapter.ClickListener {

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

    @Override
    public void showImageList(List<Image> images) {

    }

    @Override
    public void showVideoList(List<Video> videos) {

    }

    @Override
    public void showAlbumList(List<Album> albums) {

    }

    @Override
    public void onImageItemClick(Image image) {

    }

    @Override
    public void onImageItemLongClick(Image image) {

    }

    @Override
    public void onImageItemClick(Video video) {

    }

    @Override
    public void onImageItemLongClick(Video video) {

    }
}
