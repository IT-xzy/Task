package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.BannerDao;
import com.xiaobo.demo.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public List<Banner> getList(Banner banner, Map<String,Object> pageData){
        return bannerDao.getList(banner,pageData);
    }
    @Override
    public Boolean add(Banner banner){
        return bannerDao.add(banner);
    }
    @Override
    public Boolean update(Banner banner){
        return bannerDao.update(banner);
    }
    @Override
    public Integer updateBatch(Banner banner, ArrayList idList){
        return bannerDao.updateBatch(banner,idList);
    }
    @Override
    public Integer updateBatchSort(ArrayList bannerList){
        return bannerDao.updateBatchSort(bannerList);
    }
    @Override
    public Boolean delete(Banner banner){
        return bannerDao.delete(banner);
    }
}
