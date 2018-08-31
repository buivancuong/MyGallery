package com.example.acsim.mygallery.ui.main.video;

import com.example.acsim.mygallery.model.Video;

import java.util.List;

public interface VideoFragmentContractor {

    interface VideoFragmentView {
        void showVideoList(List<Video> videos);
    }

    interface VideoFragmentPresenter {
        void getVideoList();
        Video getVideo(String idVideo);
        void delVideo(List<String> idVideo);
    }

}
