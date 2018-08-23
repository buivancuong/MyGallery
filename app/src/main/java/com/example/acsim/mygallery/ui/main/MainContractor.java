package com.example.acsim.mygallery.ui.main;

//Đây là Interface khái quát tất cả các hoạt động của Main Activity; bao gồm 1 View đại diện
//cho tầng hiển thị dữ liệu (UI) và 1 Presenter làm cầu nối điều phối các hoạt động giao vận
//dữ liệu giữa UI và DB. Presenter cũng là nơi thực hiện các logic để điều phối hoạt động được
//UI nhận vào.

import com.example.acsim.mygallery.model.Album;
import com.example.acsim.mygallery.model.Image;
import com.example.acsim.mygallery.model.Video;

import java.util.List;

public interface MainContractor {

    interface View {

//        void showImageList (List<Image> images);
//
//        void showVideoList (List<Video> videos);
//
//        void showAlbumList (List<Album> albums);

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
