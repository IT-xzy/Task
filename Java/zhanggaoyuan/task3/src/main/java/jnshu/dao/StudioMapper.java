package jnshu.dao;

import jnshu.model.Studio;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioMapper {
    int deleteByPrimaryKey(Integer studioId);

    int insert(Studio record);

//    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Integer studioId);

    int updateByPrimaryKeySelective(Studio record);

    //    查询工作室信息
    Studio selectStudio();
//    int updateByPrimaryKey(Studio record);
}