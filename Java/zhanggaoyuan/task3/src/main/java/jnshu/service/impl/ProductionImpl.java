package jnshu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jnshu.dao.PeopleMapper;
import jnshu.dao.ProductionMapper;
import jnshu.dao.StudioMapper;
import jnshu.model.People;
import jnshu.model.Production;
import jnshu.model.Studio;
import jnshu.service.ProductionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductionImpl implements ProductionService{
    @Autowired
    ProductionMapper productionMapper;
    @Autowired
    StudioMapper studioMapper;
    @Autowired
    PeopleMapper peopleMapper;

    @Override
    public int deleteProductionByPrimaryKey(Integer productionId) {
        return productionMapper.deleteByPrimaryKey (productionId);
    }

    @Override
    public int insertProduction(Production record) {
        return productionMapper.insert (record);
    }

    @Override
    public Production selectProductionByPrimaryKey(Integer productionId) {
        return productionMapper.selectByPrimaryKey (productionId);
    }

    @Override
    public int updateProductionByPrimaryKeySelective(Production record) {
        return productionMapper.updateByPrimaryKeySelective (record);
    }

//    查询作品简单信息
    @Override
    public List selectProduction(int currentPage,int pageSize) {
        if (currentPage<1){currentPage=1;}
        int i=(currentPage-1)*pageSize;
        Map map = new HashMap<String, Object> ();
        map.put ("start",i );
        map.put ("pagesize", pageSize);
        List rs=productionMapper.selectProduction (map);
        return rs;
    }
//查询作品总数
    @Override
    public int selectProductionTotal() {
        return productionMapper.selectTotal ();
    }
//关键字查询
    @Override
    public List selectKeyword(int currentPage,int pageSize,String data) {
        PageHelper.offsetPage (currentPage-1, pageSize);
        return productionMapper.selectKeyword (data);
    }
    //    查询二级菜单对应作品
    @Override
    public List selectSubmenu(int currentPage,int pageSize,int submenuId) {
        PageHelper.offsetPage (currentPage-1,pageSize );
        return productionMapper.selectSubmenu (submenuId);
    }
//查询作品详细信息
    @Override
    public Production selectProductionDetail(int productionId) {
        return productionMapper.selectProductionDetail (productionId);
    }


    @Override
    public int deleteStudioByPrimaryKey(Integer studioId) {
        return studioMapper.deleteByPrimaryKey (studioId);
    }

    @Override
    public int insertStudio(Studio record) {
        return studioMapper.insert (record);
    }

    @Override
    public Studio selectStudioByPrimaryKey(Integer studioId) {
        return studioMapper.selectByPrimaryKey (studioId);
    }

    @Override
    public int updateStudioByPrimaryKeySelective(Studio record) {
        return studioMapper.updateByPrimaryKeySelective (record);
    }


    @Override
    public int deletePeopleByPrimaryKey(Integer peopleId) {
        return peopleMapper.deleteByPrimaryKey (peopleId);
    }

    @Override
    public int insertPeople(People record) {
        return peopleMapper.insert (record);
    }

    @Override
    public People selectPeopleByPrimaryKey(Integer peopleId) {
        return peopleMapper.selectByPrimaryKey (peopleId);
    }

    @Override
    public int updatePeopleByPrimaryKeySelective(People record) {
        return peopleMapper.updateByPrimaryKeySelective (record);
    }

    @Override
    public Studio selectStudio() {
        return studioMapper.selectStudio ();
    }

    @Override
    public List selectArtist() {
        return peopleMapper.selectArtist ();
    }

    @Override
    public List selectWorker(int currentPage, int pageSize) {
        PageHelper.offsetPage (currentPage-1, pageSize);
        return peopleMapper.selectWorker ();
    }
}
