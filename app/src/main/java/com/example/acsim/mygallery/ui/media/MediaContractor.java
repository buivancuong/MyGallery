package com.example.acsim.mygallery.ui.media;

public interface MediaContractor {

    interface ViewMediaView {
        void showImage(String idImage);
        void showVideo(String idVideo);
    }

    interface ViewMediaPresenter {
        void editImage(String idImage);
        void delImage(String idImage);
        void shareImage(String idImage);
        void changeFavorite(String idImage);
    }

}
