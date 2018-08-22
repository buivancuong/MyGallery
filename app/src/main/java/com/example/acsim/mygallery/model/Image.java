package com.example.acsim.mygallery.model;

//Đây là class đại diện cho 1 hình ảnh cụ thể. Do Gallery chỉ sử dụng dữ liệu trực tiếp từ thiết
//bị, nên class này chỉ lưu trữ các String là các đường dẫn đến tệp media, không lưu thông tin
//bitmap của tệp hình ảnh cũng như thumbnail của nó. Sử dụng Builder Pattern để có thêm tùy chọn
//tạo hình ảnh trong quá trình code.


public class Image {

    private String idImage;
    private String nameImage;
    private String modifyImage;
    private String pathImage;
    private boolean isImage;

    public Image() {
    }

    private Image(Builder builder) {
        this.idImage = builder.idImage;
        this.nameImage = builder.nameImage;
        this.modifyImage = builder.modifyImage;
        this.pathImage = builder.pathImage;
        this.isImage = builder.isImage;
    }

    public static class Builder {

        private String idImage = "";
        private String nameImage = "";
        private String modifyImage = "";
        private String pathImage = "";
        private boolean isImage = true;

        public Builder setIdImage (String id) {
            idImage = id;
            return this;
        }

        public Builder setNameImage (String name) {
            nameImage = name;
            return this;
        }

        public Builder setModifyImage (String time) {
            modifyImage = time;
            return this;
        }

        public Builder setPathImage (String path) {
            pathImage = path;
            return this;
        }

        public Builder setIsImage (boolean image) {
            isImage = image;
            return this;
        }

        public Image builder () {
            return new Image(this);
        }

    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getModifyImage() {
        return modifyImage;
    }

    public void setModifyImage(String modifyImage) {
        this.modifyImage = modifyImage;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }
}
