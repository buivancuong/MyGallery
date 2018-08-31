package com.example.acsim.mygallery.data;

//Đây là 1 đối tượng Singleton cụ thể, các thành phần khác của UI sẽ sử dụng đối tượng này để
//tương tác với dữ liệu hình ảnh.
//Đối tượng Cơ sở dữ liệu này chỉ khưởi tạo được khi có Context để chắc chắn rằng không có hoạt
//động background nào có thể truy cập và tương tác với cơ sở dữ liệu.
//Đây là 1 đối tượng Singleton, được khởi tạo bằng Singleton Pattern để đảm bảo chỉ có duy nhất
//1 đối tượng đại diện cho cơ sở dữ liệu.
//Đối tượng này sử dụng Content Resolver, cùng với Content Provider tại DB, sẽ thực hiện các
//quá trình truy cập và tương tác với tệp hình ảnh có trong thiết bị.

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.example.acsim.mygallery.model.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageRepo implements ImageRepository {

    private Context context;

    @SuppressLint("StaticFieldLeak")
    private static ImageRepo instance;

    private Uri imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    private ImageRepo(Context context) {
        this.context = context;
    }

    public static ImageRepo getInstance (Context context) {
        if (instance == null) {
            instance = new ImageRepo(context);
        }
        return instance;
    }

    @Override
    public List<Image> getAllImage() {
        ContentResolver imageContentResolver = this.context.getContentResolver();
        @SuppressLint("Recycle") Cursor imageCursor = imageContentResolver.query(imageUri, null, null, null, null);
        assert imageCursor != null;
        imageCursor.moveToFirst();
        List<Image> listImage = new ArrayList<>();
        while (imageCursor.moveToNext()) {
            Image image = new Image();
            image.setIdImage(imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media._ID)));
            image.setNameImage(imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
            image.setModifyImage(imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED)));
            image.setImage(true);
            image.setPathImage(imageCursor.getString(imageCursor.getColumnIndex(String.valueOf(MediaStore.Images.Media.DATA))));
            Log.i("ID là", image.getIdImage());
            Log.i("Name là", image.getNameImage());
            Log.i("Modify là", image.getModifyImage());
            Log.i("Path là", image.getPathImage());
            listImage.add(image);
        }
        return listImage;
    }

    @Override
    public Image getImage(String idImage) {
        ContentResolver imageContentResolver = this.context.getContentResolver();
        @SuppressLint("Recycle") Cursor imageCursor = imageContentResolver.query(imageUri, null, "WHERE ID =", new String[]{idImage}, null);
        Image image = new Image();
        assert imageCursor != null;
        image.setPathImage(imageCursor.getString(imageCursor.getColumnIndex(String.valueOf(MediaStore.Images.Media.DATA))));
        image.setNameImage(imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
        image.setModifyImage(imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED)));
        image.setImage(true);
        return image;
    }

    @Override
    public void addImage(String idImage) {
//        Cursor imageCursor = imageContentResolver.query(imageUri, null, "WHERE ID =", new String[]{idImage}, null);

    }

    @Override
    public void delImage(String idImage) {
        ContentResolver imageContentResolver = this.context.getContentResolver();
        @SuppressLint("Recycle") Cursor imageCursor = imageContentResolver.query(imageUri, null, "WHERE ID =", new String[]{idImage}, null);
        assert imageCursor != null;
        imageContentResolver.delete((Uri) imageCursor, idImage, null);
        getAllImage();
    }

    @Override
    public void updateImage(Image image) {

    }

}
