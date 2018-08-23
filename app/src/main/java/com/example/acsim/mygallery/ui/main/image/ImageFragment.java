package com.example.acsim.mygallery.ui.main.image;

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
import com.example.acsim.mygallery.model.Image;
import com.example.acsim.mygallery.ui.main.ClickListener;

import java.util.List;

public class ImageFragment extends android.support.v4.app.Fragment implements ImageAdapter.ClickListener, ImageFragmentContractor.ImageFragmentView {

    RecyclerView imageFragmentRecycleView;
    ImageAdapter imageAdapter;
    ClickListener clickListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.image_fragment, container, false);

        imageFragmentRecycleView = view.findViewById(R.id.mainImageFragmentRecyclerView);
        imageAdapter = new ImageAdapter();
        imageAdapter.setClickListener(this);
        imageFragmentRecycleView.setAdapter(imageAdapter);
        assert container != null;
        imageFragmentRecycleView.setLayoutManager(new GridLayoutManager(getActivity(), 4));

        return view;
    }

    @Override
    public void onImageItemClick(Image image) {
        if (clickListener != null) {
            clickListener.itemClick(image);
        }
    }

    @Override
    public void onImageItemLongClick(Image image) {
        if (clickListener != null) {
            clickListener.longClick(image);
        }
    }

    @Override
    public void showImageList(List<Image> images) {
        imageAdapter.setImages(images);
    }
}
