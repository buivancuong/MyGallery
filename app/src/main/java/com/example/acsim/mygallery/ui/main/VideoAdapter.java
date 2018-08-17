package com.example.acsim.mygallery.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acsim.mygallery.R;
import com.example.acsim.mygallery.model.Video;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<Video> {

    Context context;
    int resource;
    List<Video> objects;

    public VideoAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Video> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        @SuppressLint("ViewHolder") View view = View.inflate(context, resource, null);
        ImageView videoThumbnai = view.findViewById(R.id.videoThumbnai);
        TextView videoName = view.findViewById(R.id.videoName);

        Video itemVideo = objects.get(position);
        videoThumbnai.setImageBitmap();

        return super.getView(position, convertView, parent);
    }
}
