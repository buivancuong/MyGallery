package com.example.acsim.mygallery.ui.main.video;

//Đây là Fragment chứa danh sách các tệp tin hình ảnh có trong thiết bị.
//Thumbnail của tất cả các tệp hình ảnh trong thiết bị sẽ được đổ vào Recycler View của Fragment
//này thông qua ImageAdapter là 1 adapter lấy dữ liệu từ 1 thành phần hình ảnh, đổ vào
//Recycler View trong Fragment này.

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acsim.mygallery.R;

public class VideoFragment extends android.support.v4.app.Fragment {

    RecyclerView videoFragmentRecycleView;
    VideoAdapter videoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.video_fragment, container, false);

        videoFragmentRecycleView = view.findViewById(R.id.mainVideoFragmentRecyclerView);
        videoAdapter = new VideoAdapter();
        videoFragmentRecycleView.setAdapter(videoAdapter);
        assert container != null;
        videoFragmentRecycleView.setLayoutManager(new GridLayoutManager(container.getContext(), 2));

        return view;
    }
}
