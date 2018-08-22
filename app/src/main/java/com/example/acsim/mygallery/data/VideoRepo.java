package com.example.acsim.mygallery.data;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.acsim.mygallery.model.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoRepo implements VideoRepository {

    @SuppressLint("StaticFieldLeak")
    private static VideoRepo instance;
    private Context context;

    private Uri videoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    private VideoRepo(Context context) {
        this.context = context;
    }

    public static VideoRepo getInstance (Context context) {
        if (instance == null) {
            instance = new VideoRepo(context);
        }
        return instance;
    }

    @Override
    public List<Video> getAllVideo() {
        ContentResolver videoContentResolver = this.context.getContentResolver();
        Cursor videoCursor = videoContentResolver.query(videoUri, null, null, null, null);
        assert videoCursor != null;
        videoCursor.moveToFirst();
        List<Video> listVideo = new ArrayList<>();
        while (videoCursor.moveToNext()) {
            Video video = new Video();
            video.setIdVideo(videoCursor.getString(videoCursor.getColumnIndex(MediaStore.Video.Media._ID)));
            video.setModifyVideo(videoCursor.getString(videoCursor.getColumnIndex(MediaStore.Video.Media.DATE_MODIFIED)));
            video.setNameVideo(videoCursor.getString(videoCursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME)));
            video.setVideo(true);
            video.setPathVideo(videoCursor.getString(videoCursor.getColumnIndex(String.valueOf(MediaStore.Video.Media.DATA))));
            listVideo.add(video);
        }

        return listVideo;
    }

    @Override
    public Video getVideo(String idVideo) {
        ContentResolver videoContentResolver = this.context.getContentResolver();
        Cursor videoCursor = videoContentResolver.query(videoUri, null, "WHERE ID =", new String[]{idVideo}, null);
        Video video = new Video();
        assert videoCursor != null;
        video.setPathVideo(videoCursor.getString(videoCursor.getColumnIndex(String.valueOf(MediaStore.Video.Media.EXTERNAL_CONTENT_URI))));
        return video;
    }

    @Override
    public void addVideo(Video video) {

    }

    @Override
    public void delVideo(String idVideo) {
        ContentResolver videoContentResolver = this.context.getContentResolver();
        Cursor videoCursor = videoContentResolver.query(videoUri, null, "WHERE ID =", new String[]{idVideo}, null);
        videoContentResolver.delete((Uri) videoCursor, idVideo, null);
        getAllVideo();
    }
}
