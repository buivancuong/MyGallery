package com.example.acsim.mygallery.data;

//Đây là Interface để khái quát lại những công việc nào cần phải thực hiện khi thao tác với
//dữ liệu hình ảnh có trong thiết bị.
//Hình ảnh trong máy có thể rất nặng, nhưng class Image lại rất nhẹ vì không chứa thông tin
//bitmap.

import android.graphics.Bitmap;

import com.example.acsim.mygallery.model.Image;

import java.util.List;

public interface ImageRepository {

    List<Image> getAllImage();

    Image getImage(String idImage);

    void addImage(String idImage);

    void delImage(String idImage);

    void updateImage(Image image);

}
