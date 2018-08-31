package com.example.acsim.mygallery.ui.main.image;

import com.example.acsim.mygallery.model.Image;

import java.util.List;

public interface ImageFragmentContractor {

    interface ImageFragmentView{
        void showImageList (List<Image> images);
    }

    interface ImageFragmentPresenter{
        void getImageList();
        Image getImage(String idImage);
        void delImage(List<String> idImage);
    }

}
