package com.example.acsim.mygallery.data;

import com.example.acsim.mygallery.model.Album;

import java.util.List;

public interface AlbumRepository {

    List<Album> getAllAlbum();

    Album getAlbum(String idAlbum);

}
