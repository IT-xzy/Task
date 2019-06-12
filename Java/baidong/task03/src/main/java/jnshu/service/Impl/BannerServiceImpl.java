package jnshu.service.Impl;

import jnshu.mapper.BannerMapper;
import jnshu.model.Banner;
import jnshu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
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

    public List<Banner> selectByDynamicCondition(Long status, String name){
        return bannerMapper.selectByDynamicCondition(status,name);
    }
}
