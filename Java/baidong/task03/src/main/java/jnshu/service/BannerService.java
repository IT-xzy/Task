package jnshu.service;

import jnshu.model.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerService {

    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectByDynamicCondition(@Param("status") Long status, @Param("name") String name);
}
