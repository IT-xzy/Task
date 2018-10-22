package com.artist.dao;

import com.artist.pojo.ImageAndVideo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ImgAndVideDaoTest {
    @Autowired
    private ImgAndVideDao imgAndVideDao;

    @Test
    public void queryImgVides() {
       List<ImageAndVideo> list= imgAndVideDao.queryImgVides(1);
        System.out.println(list);
    }

    @Test
    public void saveImgVide() {
        ImageAndVideo i=new ImageAndVideo();
        i.setImgVideName("爱上祢");
        i.setProductionId(1);
        i.setUploadTime(System.currentTimeMillis());
        i.setUpdateTime(System.currentTimeMillis());
        imgAndVideDao.saveImgVide(i);
    }

    @Test
    public void delImgVides() {
        imgAndVideDao.delImgVides(2);
    }

    @Test
    public void delImgVide() {
        imgAndVideDao.delImgVide(4);
    }

    @Test
    public void updateImgVide() {
        ImageAndVideo i=new ImageAndVideo();
        i.setImgVideoId(1);
        i.setImgVideName("爱上祢");
        i.setProductionId(2);
        i.setUploadTime(System.currentTimeMillis());
        i.setUpdateTime(System.currentTimeMillis());
        imgAndVideDao.updateImgVide(i);
    }
}