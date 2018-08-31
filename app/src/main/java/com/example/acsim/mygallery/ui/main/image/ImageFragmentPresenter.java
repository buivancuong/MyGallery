package com.example.acsim.mygallery.ui.main.image;

import com.example.acsim.mygallery.data.ImageRepository;
import com.example.acsim.mygallery.model.Image;

import java.util.List;

public class ImageFragmentPresenter implements ImageFragmentContractor.ImageFragmentPresenter {

    private ImageFragmentContractor.ImageFragmentView imageFragmentView;
    private ImageRepository imageRepository;

    @Override
    public void getImageList() {
        List<Image> images = imageRepository.getAllImage();
        imageFragmentView.showImageList(images);
    }

    @Override
    public Image getImage(String idImange) {
        return null;
    }

    @Override
    public void delImage(List<String> idImage) {
        for (String i : idImage) {
            imageRepository.delImage(i);
        }
    }

    public ImageFragmentPresenter(ImageRepository imageRepository, ImageFragmentContractor.ImageFragmentView imageFragmentView) {
        this.imageRepository = imageRepository;
        this.imageFragmentView = imageFragmentView;
    }

}
