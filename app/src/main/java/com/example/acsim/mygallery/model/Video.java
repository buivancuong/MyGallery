package com.example.acsim.mygallery.model;

public class Video {

    private String idVideo;
    private String nameVideo;
    private long modifyVideo;
    private String pathVideo;
    private boolean isVideo;

    public Video() {
    }

    private Video(Builder builder) {
        this.idVideo = builder.idVideo;
        this.nameVideo = builder.nameVideo;
        this.modifyVideo = builder.modifyVideo;
        this.pathVideo = builder.pathVideo;
        this.isVideo = builder.isVideo;
    }

    public static class Builder {

        private String idVideo = "";
        private String nameVideo = "";
        private long modifyVideo = 0;
        private String pathVideo = "";
        private boolean isVideo = true;

        public Builder setIsVideo(String id) {
            idVideo = id;
            return this;
        }

        public Builder setNameVideo(String name) {
            nameVideo = name;
            return this;
        }

        public Builder setModifyVideo(long time) {
            modifyVideo = time;
            return this;
        }

        public Builder setPathVideo(String path) {
            pathVideo = path;
            return this;
        }

        public Builder setIsVideo (boolean video) {
            isVideo = video;
            return this;
        }

        public Video builder () {
            return new Video(this);
        }

    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public long getModifyVideo() {
        return modifyVideo;
    }

    public void setModifyVideo(long modifyVideo) {
        this.modifyVideo = modifyVideo;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}
