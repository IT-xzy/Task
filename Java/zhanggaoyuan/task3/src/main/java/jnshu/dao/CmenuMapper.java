package jnshu.dao;

import jnshu.model.Cmenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CmenuMapper {
    int deleteByPrimaryKey(Integer cmenuId);

    int insert(Cmenu record);

//    int insertSelective(Cmenu record);

    Cmenu selectByPrimaryKey(Integer cmenuId);

    int updateByPrimaryKeySelective(Cmenu record);

//    查询菜单信息
    List selectMenu();
//    int updateByPrimaryKey(Cmenu record);
}