package com.example.acsim.mygallery.ui.media;

import com.example.acsim.mygallery.data.ImageRepository;

public class ViewMediaPresenter implements MediaContractor.ViewMediaPresenter {

    private MediaContractor.ViewMediaView viewMediaView;
    private ImageRepository imageRepository;

    @Override
    public void editImage(String idImage) {

    }

    @Override
    public void delImage(String idImage) {
        imageRepository.delImage(idImage);
    }

    @Override
    public void shareImage(String idImage) {

    }

    @Override
    public void changeFavorite(String idImage) {

    }

    public ViewMediaPresenter (MediaContractor.ViewMediaView viewMediaView, ImageRepository imageRepository) {
        this.viewMediaView = viewMediaView;
        this.imageRepository = imageRepository;
    }

}
