package com.ptteng.service.impl;


import com.ptteng.dao.BannerMapper;
import com.ptteng.model.Banner;
import com.ptteng.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImp implements BannerService {
    @Autowired
    BannerMapper bannerMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return bannerMapper.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }

    @Override
    public List<Banner> selectByDynamicCondition(Integer state , String createBy) {
        return bannerMapper.selectByDynamicCondition(state,createBy);
    }
}
