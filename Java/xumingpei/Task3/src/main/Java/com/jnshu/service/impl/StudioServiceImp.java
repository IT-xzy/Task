package com.jnshu.service.impl;

import com.jnshu.dao.StudioMapper;
import com.jnshu.pojo.SecondWork;
import com.jnshu.pojo.Studio;
import com.jnshu.pojo.User;
import com.jnshu.service.StudioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class StudioServiceImp implements StudioService {
    private static Logger logger = Logger.getLogger(StudioServiceImp.class);

    @Autowired
    StudioMapper studioMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        int ID = studioMapper.deleteByPrimaryKey(id);
        logger.info("删除的id："+id);
        return ID;
    }

    @Override
    public int insert(Studio record) {
        int Record = studioMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(Studio record) {
        int Recond = studioMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public Studio selectByPrimaryKey(Long id) {
        Studio studio = studioMapper.selectByPrimaryKey(id);
        logger.info("查询的ID"+id);
        return studio;
    }

    @Override
    public int updateByPrimaryKeySelective(Studio record) {
        int Recond = studioMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(Studio record) {
        int Recond = studioMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<Studio> selectByDynamic(String name, Integer status) {
        List<Studio> list=studioMapper.selectByDynamic(name,status);
        logger.info(list.toString());
        return list;
    }
}
