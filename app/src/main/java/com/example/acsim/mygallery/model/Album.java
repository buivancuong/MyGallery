package com.example.acsim.mygallery.model;

public class Album {

    private String idAlbum;
    private String nameAlbum;
    private String modifyAlbum;
    private String pathAlbum;

    public Album (){
    }

    private Album(Builder builder) {
        this.idAlbum = builder.idAlbum;
        this.nameAlbum = builder.nameAlbum;
        this.modifyAlbum = builder.modifyAlbum;
        this.pathAlbum = builder.pathAlbum;
    }

    public static class Builder {

        private String idAlbum = "";
        private String nameAlbum = "";
        private String modifyAlbum = "";
        private String pathAlbum = "";

        public Builder setIDAlbum(String id) {
            idAlbum = id;
            return this;
        }

        public Builder setNameAlbum (String name) {
            nameAlbum = name;
            return this;
        }

        public Builder setModifyAlbum (String modify) {
            modifyAlbum = modify;
            return this;
        }

        public Builder setPathAlbum (String path) {
            pathAlbum = path;
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

    public String getModifyAlbum() {
        return modifyAlbum;
    }

    public void setModifyAlbum(String modifyAlbum) {
        this.modifyAlbum = modifyAlbum;
    }

    public String getPathAlbum() {
        return pathAlbum;
    }

    public void setPathAlbum(String pathAlbum) {
        this.pathAlbum = pathAlbum;
    }
}
