package com.art.service.impl;

import com.art.mapper.StudioMapper;
import com.art.pojo.Studio;
import com.art.service.StudioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工作室管理
 * @author suger
 * @date 2018/11/5 20:51
 */
@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    StudioMapper studioMapper;
    private static final Logger logger = LoggerFactory.getLogger(StudioServiceImpl.class);

    // 新增工作室简介
    @Override
    public Boolean insert(Studio record) {
        int result = studioMapper.insertSelective(record);
        logger.warn("新增工作室简介：{}",result);
        if(result==1){
            return  true;
        }
        return false;
    }

    // 删除工作室简介
    @Override
    public Boolean delete(Integer id) {
        int result = studioMapper.deleteByPrimaryKey(id);
        logger.warn("删除工作室简介：{}",result);
        if(result==1){
            return true;
        }
        return false;
    }

    // 查询单个工作室简介
    @Override
    public Studio getStudio(Integer id) {
        logger.info("工作室简介ID:"+id);
        Studio studio = studioMapper.selectByPrimaryKey(id);
        return studio;
    }

    // 查询工作室简介列表

    @Override
    public List<Studio> getStudio(Boolean status, String updateBy) {
        logger.info("查询工作室列表");
        List<Studio> list = studioMapper.selectByCondition(status,updateBy);
        return list;
    }

    //  更新工作室简介
    @Override
    public Boolean update(Studio record) {
        int result = studioMapper.updateByPrimaryKeySelective(record);
        logger.info("更新工作室简介：{}",result);
        if(result==1){
            return  true;
        }
        return false;
    }
}
