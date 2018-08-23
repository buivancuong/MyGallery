package com.example.acsim.mygallery.ui.main;

//Runtime Permission

//Main Activity sẽ chứa 1 ViewPager được kết nối tương tác với các Tab để chuyển đổi qua lại
//giữa các Fragment trong ViewPager.
//ViewPager chứa các Fragment là một thành phần chứa trong nó nội dung của các tệp tin media có
//trong thiết bị, được phân loại theo tên các Tab {Image, Video, Album}
//Để đổ dữ liệu từ các Fragment vào ViewPager để hiển thị lên Main Activity, ta cần sử dụng
// MainViewPagerAdapter là 1 adapter lấy dữ liệu từ các Fragment tương ứng.

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.acsim.mygallery.R;
import com.example.acsim.mygallery.data.ImageRepo;
import com.example.acsim.mygallery.data.VideoRepo;
import com.example.acsim.mygallery.model.Album;
import com.example.acsim.mygallery.model.Image;
import com.example.acsim.mygallery.model.Video;
import com.example.acsim.mygallery.ui.main.image.ImageFragment;
import com.example.acsim.mygallery.ui.main.video.VideoFragment;

public class MainActivity extends AppCompatActivity implements MainContractor.View, ClickListener {

    MainPresenter mainPresenter;
    TabLayout mainTabLayout;
    String tabItem[] = {"Image", "Video", "Album"};

    ImageFragment imageFragment;
    VideoFragment videoFragment;
    AlbumFragment albumFragment;

    ViewPager mainViewPager;
    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTabLayout = findViewById(R.id.mainTabLayout);
        mainViewPager = findViewById(R.id.mainViewPager);
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainViewPagerAdapter);

        mainTabLayout.setupWithViewPager(mainViewPager);

        imageFragment = new ImageFragment();
        videoFragment = new VideoFragment();
        albumFragment = new AlbumFragment();

        mainPresenter = new MainPresenter(ImageRepo.getInstance(this), VideoRepo.getInstance(this),this);
        mainPresenter.getImageList();
        mainPresenter.getVideoList();
        mainPresenter.getAlbumList();

    }

    @Override
    public void itemClick(Object object) {
        if (object instanceof Image) {
            Image image = (Image) object;
        } else if (object instanceof Video) {
            Video video = (Video) object;
        } else {
            Album album = (Album) object;
        }
    }

    @Override
    public void longClick(Object object) {

    }

    public class MainViewPagerAdapter extends FragmentPagerAdapter {

        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabItem[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    return imageFragment;
                }
                case 1: {
                    return videoFragment;
                }
                default: {
                    return albumFragment;
                }
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
