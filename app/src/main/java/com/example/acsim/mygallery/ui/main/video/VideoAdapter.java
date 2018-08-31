package com.example.acsim.mygallery.ui.main.video;

import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.example.acsim.mygallery.R;
import com.example.acsim.mygallery.data.VideoRepo;
import com.example.acsim.mygallery.model.Video;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * lớp này có tác dụng là cầu nối giữa danh sách các image cần hiển thị và RecyclerView
 * hay nói cách khác, lớp này sẽ lấy danh sách image để đổ vào view (hiển thị cho người dùng)
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videos;

    private VideoClickListener videoClickListener;

    public VideoAdapter () {
        videos = new ArrayList<>();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_video, viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        videoViewHolder.bindVideo(videos.get(i));
    }

    @Override
    public int getItemCount() {
        return videos != null ? videos.size() : 0;
    }

    public void setVideoClickListener(VideoClickListener videoClickListener) {
        this.videoClickListener = videoClickListener;
    }

//Phương thức này để cập nhật danh sách image trên view
//Giả sử danh sách image trên view cần cập nhật bằng cách thay đổi danh sách image
//thì truyền danh sách task mới vào phương thức này, sau đó danh sách mới sẽ được
//tự động cập nhật trên RecyclerView

    public void setVideos(List<Video> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

// đây là class có nhiều ý nghĩa nhất của RecyclerView
// class này là các ViewHolder, có tác dụng lưu giữ các View đã được tạo ra bởi
// Adapter, đổ dữ liệu từ model lên view và tái sử dụng lại các View đã được tạo ra,
// làm tăng hiệu năng hoạt động của RecyclerView rất nhiều so với ListView

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        Video video;
        ConstraintLayout videoItem;
        ImageView videoViewItem;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoItem = itemView.findViewById(R.id.videoItem);
            videoViewItem = videoItem.findViewById(R.id.videoThumbnail);
        }

        public void bindVideo (final Video video) {
            this.video = video;

//            Picasso.with(itemView.getContext()).load(video.getPathVideo()).into(videoViewItem);

            videoViewItem.setImageURI(Uri.parse(video.getPathVideo()));
            videoViewItem.setImageBitmap(VideoRepo.getInstance().);

            videoItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (videoClickListener != null) {
                        videoClickListener.onVideoItemClick(video);
                    }
                }
            });

            videoItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (videoClickListener != null) {
                        videoClickListener.onVideoItemLongClick(video);
                    }
                    return false;
                }
            });
        }

    }

    public interface VideoClickListener {
        void onVideoItemClick(Video video);
        void onVideoItemLongClick(Video video);
    }

}
