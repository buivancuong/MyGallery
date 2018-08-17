package com.example.acsim.mygallery.ui.main;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acsim.mygallery.R;

public class VideoFragment extends android.support.v4.app.Fragment {

    Uri videoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.video_fragment, container, false);

        ContentResolver videoContentResolver = getActivity().getContentResolver();
        Cursor videoCursor = videoContentResolver.query(videoUri, null, null, null, null);
        videoCursor.moveToFirst();

        while (!videoCursor.isAfterLast()) {

            String pathVideo = videoCursor.getString(videoCursor.getColumnIndex(MediaStore.Video.Media.DATA));
            String nameVideo = videoCursor.getString(videoCursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME));

            long idVideo = videoCursor.getColumnIndex(MediaStore.Video.Media._ID);
            Bitmap videoBitmap = MediaStore.Video.Thumbnails.getThumbnail(videoContentResolver, idVideo, MediaStore.Video.Thumbnails.MINI_KIND, null);

        }

        return view;
    }
}
