package com.jnshu.service.impl;

import com.jnshu.controller.ReplyController;
import com.jnshu.dao.BannerMapper;
import com.jnshu.pojo.Banner;
import com.jnshu.service.BannerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/10 - 12:27
 */
@Service
public class BannerServiceImp implements BannerService {
    private static Logger logger = Logger.getLogger(BannerServiceImp.class);

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        int ID = bannerMapper.deleteByPrimaryKey(id);
        logger.info("删除的id："+id);
        return ID;
    }

    @Override
    public int insert(Banner record) {
        int Record = bannerMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(Banner record) {
        int Recond = bannerMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public Banner selectByPrimaryKey(Long id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        logger.info("查询的ID"+id);
        return banner;
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        int Recond = bannerMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        int Recond = bannerMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<Banner> selectByDynamic(String updateBy, Integer status) {
        List<Banner> list=bannerMapper.selectByDynamic(updateBy,status);
        logger.info(list.toString());
        return list;
    }
}
