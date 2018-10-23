package com.ptteng.service;

import com.ptteng.dao.BannerDao;
import com.ptteng.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {

    @Autowired
    private BannerDao bannerDao;

    public List<Banner> findBanner() {
        return bannerDao.findBanner();
    }

    public Boolean deleteById(long id){
        return bannerDao.deleteById(id);
    }

    public Boolean updateBanner(Banner banner){
        banner.setUpdateAt(System.currentTimeMillis());
        banner.setUpdateBy(33L);
        return bannerDao.updateBanner(banner);
    }

    public long insertBanner(Banner banner){
        banner.setCreateAt(System.currentTimeMillis());
        banner.setUpdateAt(System.currentTimeMillis());
        banner.setCreateBy(11L);
        banner.setUpdateBy(22L);
        return bannerDao.insertBanner(banner);
    }




}
