package jnshu.dao;

import org.springframework.stereotype.Repository;
import jnshu.model.Banner;

import java.util.List;

@Repository
public interface BannerMapper {
    int deleteByPrimaryKey(Integer bannerId);

    int insert(Banner record);

//    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer bannerId);

    int updateByPrimaryKeySelective(Banner record);

    List selectBanner ();

//    int updateByPrimaryKey(Banner record);
}