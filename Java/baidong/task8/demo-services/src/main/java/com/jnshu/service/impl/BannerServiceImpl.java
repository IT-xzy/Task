package com.jnshu.service.impl;

import com.jnshu.mapper.BannerMapper;
import com.jnshu.model.Banner;
import com.jnshu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {


    @Autowired(required = false)
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }
}
