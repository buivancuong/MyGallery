package com.example.acsim.mygallery.ui.main;

import com.example.acsim.mygallery.data.ImageRepository;
import com.example.acsim.mygallery.data.VideoRepository;
import com.example.acsim.mygallery.model.Image;
import com.example.acsim.mygallery.model.Video;

import java.util.List;

public class MainPresenter implements MainContractor.Presenter {

    private MainContractor.View view;
    private ImageRepository imageRepository;
    private VideoRepository videoRepository;

    public ImageRepository getImageRepository() {
        return imageRepository;
    }

    public VideoRepository getVideoRepository() {
        return videoRepository;
    }

    @Override
    public void getImageList() {
        List<Image> images = imageRepository.getAllImage();
        view.showImageList(images);
    }

    @Override
    public void getVideoList() {
        List<Video> videos = videoRepository.getAllVideo();
        view.showVideoList(videos);
    }

    @Override
    public void getAlbumList() {

    }

    @Override
    public void delImages(List<String> id) {
        for (String i : id) {
            imageRepository.delImage(i);
        }
    }

    @Override
    public void delVideos(List<String> id) {
        for (String i : id) {
            videoRepository.delVideo(i);
        }

    }

    @Override
    public void delAlbums(List<String> id) {

    }

    @Override
    public void addAlbum(String id) {

    }

    public MainPresenter (ImageRepository imageRepository, VideoRepository videoRepository, MainContractor.View view) {
        this.imageRepository = imageRepository;
        this.videoRepository = videoRepository;
        this.view = view;
    }
}
