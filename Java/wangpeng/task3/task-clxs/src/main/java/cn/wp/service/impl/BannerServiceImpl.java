package cn.wp.service.impl;

import cn.wp.dao.BannerDao;
import cn.wp.model.Banner;
import cn.wp.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BannerServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:17
 * @Version: 1.0
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerDao bannerDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return bannerDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner record) {
        return bannerDao.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return bannerDao.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Long id) {
        return bannerDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Banner> selectAll() {
        return bannerDao.selectAll();
    }

    @Override
    public List<Banner> selectByDynamicCondition(Integer state, String createBy) {
        return bannerDao.selectByDynamicCondition(state, createBy);
    }
}
