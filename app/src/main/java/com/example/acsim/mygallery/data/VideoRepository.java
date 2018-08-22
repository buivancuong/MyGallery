package com.example.acsim.mygallery.data;

import com.example.acsim.mygallery.model.Video;

import java.util.List;

public interface VideoRepository {

    List<Video> getAllVideo();

    Video getVideo(String idVideo);

    void addVideo(Video video);

    void delVideo(String idVideo);

}
