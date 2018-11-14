package jnshu.dao;

import jnshu.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductionMapper {
    int deleteByPrimaryKey(Integer productionId);

    int insert(Production record);

//    int insertSelective(Production record);

    Production selectByPrimaryKey(Integer productionId);

    int updateByPrimaryKeySelective(Production record);

//    查询作品简单信息
    List selectProduction(Map map);

    //查询作品的总记录数
    int selectTotal();

//    模糊查询作品名字和作品简介
    List selectKeyword(String data);

    //    查询二级菜单对应作品
    List selectSubmenu(int submenuId);

    //    查询作品详细信息
    Production selectProductionDetail(int productionId);
//    int updateByPrimaryKey(Production record);
}