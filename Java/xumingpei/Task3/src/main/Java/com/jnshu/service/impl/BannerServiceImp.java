package com.jnshu.service.impl;

import com.jnshu.controller.BannerController;
import com.jnshu.dao.BannerMapper;
import com.jnshu.pojo.Banner;
import com.jnshu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author pipiretrak
 * @date 2019/3/10 - 12:27
 */
@Service
public class BannerServiceImp implements BannerService {
    @Autowired
    BannerMapper bannerMapper;
    private static Logger logger = Logger.getLogger(String.valueOf(BannerServiceImp.class));

    @Override
    public int deleteByPrimaryKey(Long id) {
        int ID = bannerMapper.deleteByPrimaryKey(id);
        logger.info("删除的id："+id);
        return ID;
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
    public List<Banner> selectByDynamic(String updateBy, Integer status) {
        List<Banner> list=bannerMapper.selectByDynamic(updateBy,status);
        logger.info(list.toString());
        return list;
    }
}
