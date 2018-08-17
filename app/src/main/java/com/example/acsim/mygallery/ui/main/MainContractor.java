package com.example.acsim.mygallery.ui.main;

import com.example.acsim.mygallery.model.Album;
import com.example.acsim.mygallery.model.Image;
import com.example.acsim.mygallery.model.Video;

import java.util.List;

public interface MainContractor {

    interface View {

        void showImageList (List<Image> images);

        void showVideoList (List<Video> videos);

        void showAlbumList (List<Album> albums);

    }

    interface Presenter {

        void getImageList();

        void getVideoList();

        void getAlbumList();

        void delImages (List<String> id);

        void delVideos (List<String> id);

        void delAlbums (List<String> id);

        void addAlbum (String id);

    }

}
