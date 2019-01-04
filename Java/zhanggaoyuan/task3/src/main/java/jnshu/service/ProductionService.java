package jnshu.service;

import jnshu.model.Studio;
import jnshu.model.People;
import jnshu.model.Production;

import java.util.List;
import java.util.Map;

public interface ProductionService {
//    Production
    int deleteProductionByPrimaryKey(Integer productionId);

    int insertProduction(Production record);

    Production selectProductionByPrimaryKey(Integer productionId);

    int updateProductionByPrimaryKeySelective(Production record);

    //    查询作品简单信息
    List selectProduction(int currentPage,int pageSize);
//    查询作品总记录数
    int selectProductionTotal();
//    模糊查询关键字
    List selectKeyword(int currentPage,int pageSize,String data);
    //    查询二级菜单对应作品
    List selectSubmenu(int currentPage,int pageSize,int submenuId);
    //    查询作品详细信息
    Production selectProductionDetail(int productionId);



//    Studio
    int deleteStudioByPrimaryKey(Integer studioId);

    int insertStudio(Studio record);

    Studio selectStudioByPrimaryKey(Integer studioId);

    int updateStudioByPrimaryKeySelective(Studio record);

    //    People
    int deletePeopleByPrimaryKey(Integer peopleId);

    int insertPeople(People record);

    People selectPeopleByPrimaryKey(Integer peopleId);

    int updatePeopleByPrimaryKeySelective(People record);

    //    查询工作室信息
    Studio selectStudio();

    //    查询艺术家信息
    List selectArtist();

    //    查询成员信息
    List selectWorker(int currentPage, int pageSize);
}
