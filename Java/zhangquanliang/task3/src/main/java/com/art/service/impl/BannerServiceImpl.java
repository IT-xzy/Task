package com.art.service.impl;

import com.art.mapper.BannerMapper;
import com.art.pojo.Banner;
import com.art.service.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suger
 * @date 2018-11-02
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;
    private static final Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Override
    public Boolean insert(Banner record) {
        int result = bannerMapper.insertSelective(record);
        logger.info("插入：{}",result);
        if(result==1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean update(Banner record) {
        int result = bannerMapper.updateByPrimaryKeySelective(record);
        logger.info("更新：{}",result);
        if(result==1){
            return true;
        }
        return false;

    }

    @Override
    public Boolean delete(Integer id) {
        int result = bannerMapper.deleteByPrimaryKey(id);
        logger.info("删除：{}",result);
        if (result==1){
            return true;
        }
        return false;
    }

    @Override
    public Banner getBanner(Integer id) {
        logger.info("查询id:{}",id);
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Banner> findBanners( Boolean status,String updateBy) {
        logger.info("banner 条件查询");
        return bannerMapper.selectByCondition(status,updateBy);
    }
}
