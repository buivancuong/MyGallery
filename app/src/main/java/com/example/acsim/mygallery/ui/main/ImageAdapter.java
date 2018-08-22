package com.example.acsim.mygallery.ui.main;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.acsim.mygallery.R;
import com.example.acsim.mygallery.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * lớp này có tác dụng là cầu nối giữa danh sách các image cần hiển thị và RecyclerView
 * hay nói cách khác, lớp này sẽ lấy danh sách image để đổ vào view (hiển thị cho người dùng)
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Image> images;

    private ClickListener clickListener;

    public ImageAdapter () {
        images = new ArrayList<>();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_image, viewGroup, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.bindImage(images.get(i));
    }

    @Override
    public int getItemCount() {
        return images != null ? images.size() : 0;
    }

    public void setClickListener (ClickListener clickListener) {
        this.clickListener = clickListener;
    }

//Phương thức này để cập nhật danh sách image trên view
//Giả sử danh sách image trên view cần cập nhật bằng cách thay đổi danh sách image
//thì truyền danh sách task mới vào phương thức này, sau đó danh sách mới sẽ được
//tự động cập nhật trên RecyclerView

    public void setImages (List<Image> images) {
        this.images = images;
        notifyDataSetChanged();
    }

// đây là class có nhiều ý nghĩa nhất của RecyclerView
// class này là các ViewHolder, có tác dụng lưu giữ các View đã được tạo ra bởi
// Adapter, đổ dữ liệu từ model lên view và tái sử dụng lại các View đã được tạo ra,
// làm tăng hiệu năng hoạt động của RecyclerView rất nhiều so với ListView

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        Image image;
        ConstraintLayout imageItem;
        ImageView imageViewItem;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.imageItem);
            imageViewItem = imageItem.findViewById(R.id.imageViewItem);
        }

        public void bindImage (final Image image) {
            this.image = image;

            Picasso.with(itemView.getContext()).load(image.getPathImage()).into(imageViewItem);

            imageItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        clickListener.onImageItemClick(image);
                    }
                }
            });

            imageItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (clickListener != null) {
                        clickListener.onImageItemLongClick(image);
                    }
                    return false;
                }
            });
        }

    }

    public interface ClickListener {
        void onImageItemClick (Image image);
        void onImageItemLongClick (Image image);
    }

}
