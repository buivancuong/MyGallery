package com.example.acsim.mygallery.model;

import java.util.ArrayList;

public class Album {

    private String idAlbum;
    private String nameAlbum;
    private ArrayList<Image> listImage;
    private ArrayList<Video> listVideo;

    public Album (){
    }

    private Album(Builder builder) {
        this.idAlbum = builder.idAlbum;
        this.nameAlbum = builder.nameAlbum;
        this.listImage = builder.listImage;
        this.listVideo = builder.listVideo;
    }

    public static class Builder {

        private String idAlbum = "";
        private String nameAlbum = "";
        private ArrayList<Image> listImage = new ArrayList<>();
        private ArrayList<Video> listVideo = new ArrayList<>();

        public Builder setIDAlbum(String id) {
            idAlbum = id;
            return this;
        }

        public Builder setNameAlbum (String name) {
            nameAlbum = name;
            return this;
        }

        public Builder setListImage (ArrayList<Image> listImg) {
            listImage = listImg;
            return this;
        }

        public Builder setListVideo (ArrayList<Video> listVd) {
            listVideo = listVd;
            return this;
        }

        public Album builder() {
            return new Album(this);
        }

    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public ArrayList<Image> getListImage() {
        return listImage;
    }

    public void setListImage(ArrayList<Image> listImage) {
        this.listImage = listImage;
    }

    public ArrayList<Video> getListVideo() {
        return listVideo;
    }

    public void setListVideo(ArrayList<Video> listVideo) {
        this.listVideo = listVideo;
    }
}
