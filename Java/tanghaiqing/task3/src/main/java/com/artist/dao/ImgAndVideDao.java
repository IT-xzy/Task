package com.artist.dao;

import com.artist.pojo.ImageAndVideo;

import java.util.List;

public interface ImgAndVideDao {
    List<ImageAndVideo> queryImgVides(Integer productionId);
    void saveImgVide(ImageAndVideo imageAndVideo);
    void delImgVides(Integer productionId);
    void delImgVide(Integer imgVideoId);
    void updateImgVide(ImageAndVideo imageAndVideo);
}
