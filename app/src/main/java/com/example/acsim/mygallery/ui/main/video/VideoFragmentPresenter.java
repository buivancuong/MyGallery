package com.example.acsim.mygallery.ui.main.video;

import com.example.acsim.mygallery.data.VideoRepository;
import com.example.acsim.mygallery.model.Video;

import java.util.List;

public class VideoFragmentPresenter implements VideoFragmentContractor.VideoFragmentPresenter {

    private VideoRepository videoRepository;
    private VideoFragmentContractor.VideoFragmentView videoFragmentView;

    @Override
    public void getVideoList() {
        List<Video> videos = videoRepository.getAllVideo();
        videoFragmentView.showVideoList(videos);
    }

    @Override
    public Video getVideo(String idVideo) {
        return null;
    }

    @Override
    public void delVideo(List<String> idVideo) {
        for (String i : idVideo){
            videoRepository.delVideo(i);
        }
    }

    public VideoFragmentPresenter (VideoRepository videoRepository, VideoFragmentContractor.VideoFragmentView videoFragmentView) {
        this.videoRepository = videoRepository;
        this.videoFragmentView = videoFragmentView;
    }

}
