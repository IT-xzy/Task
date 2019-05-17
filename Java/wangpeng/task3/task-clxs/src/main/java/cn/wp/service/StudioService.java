package cn.wp.service;

import cn.wp.model.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudioService {
    int deleteByPrimaryKey(Long id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKey(Studio record);

    List<Studio> selectAll();

    List<Studio> selectByDynamicCondition(@Param("studioName") String name, @Param("state") Long state);
}
