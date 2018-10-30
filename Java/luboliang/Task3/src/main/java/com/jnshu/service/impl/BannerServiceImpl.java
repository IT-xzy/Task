package com.jnshu.service.impl;

import com.jnshu.mapper.BannerDao;
import com.jnshu.model.Banner;
import com.jnshu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerDao bannerDao;
    @Override
    public long addBanner(Banner banner) {
        return bannerDao.addBanner(banner);
    }

    @Override
    public boolean deleteBanner(long id) {
        return bannerDao.deleteBanner(id);
    }

    @Override
    public boolean updateBanner(Banner banner) {
        return bannerDao.updateBanner(banner);
    }

    @Override
    public Banner findByBanner(long id) {
        return bannerDao.findByBanner(id);
    }

    @Override
    public List<Banner> findAllBanner() {
        return bannerDao.findAllBanner();
    }
}
