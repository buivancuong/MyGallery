package com.example.acsim.mygallery.ui.media;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.example.acsim.mygallery.R;
import com.example.acsim.mygallery.data.ImageRepo;
import com.example.acsim.mygallery.ui.main.image.ImageFragment;

@SuppressLint("Registered")
public class ViewMediaActivity extends AppCompatActivity implements MediaContractor.ViewMediaView {

    ViewMediaPresenter viewMediaPresenter;
    ViewPager viewMediaViewPager;
    ImageFragment imageFragment;
    ImageButton editImageButton, delImageButton, shareImageButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_media);

        viewMediaViewPager = findViewById(R.id.imageViewImageView);
        editImageButton = findViewById(R.id.imageButtonEditImage);
        delImageButton = findViewById(R.id.imageButtonDelete);
        shareImageButton = findViewById(R.id.imageButtonShare);

        viewMediaPresenter = new ViewMediaPresenter(this, ImageRepo.getInstance(this));


    }

    @Override
    public void showImage(String idImage) {

    }

    @Override
    public void showVideo(String idVideo) {

    }
}
