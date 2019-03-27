package com.jnshu.service.impl;

import com.jnshu.dao.FirstWorkMapper;
import com.jnshu.pojo.Banner;
import com.jnshu.pojo.FirstWork;
import com.jnshu.service.FirstWorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class FirstWorkServiceImp implements FirstWorkService {
    private static Logger logger = Logger.getLogger(FirstWorkServiceImp.class);

    @Autowired
    FirstWorkMapper firstWorkMapper;

    @Override
    public int deleteByPrimaryKey(Long firstId) {
        int ID = firstWorkMapper.deleteByPrimaryKey(firstId);
        logger.info("删除的id："+firstId);
        return ID;
    }

    @Override
    public int insert(FirstWork record) {
        int Record = firstWorkMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(FirstWork record) {
        int Recond = firstWorkMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public FirstWork selectByPrimaryKey(Long firstId) {
        FirstWork firstWork = firstWorkMapper.selectByPrimaryKey(firstId);
        logger.info("查询的ID"+firstId);
        return firstWork;
    }

    @Override
    public int updateByPrimaryKeySelective(FirstWork record) {
        int Recond = firstWorkMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(FirstWork record) {
        int Recond = firstWorkMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<FirstWork> selectByDynamic(String firstName, Integer status) {
        List<FirstWork> list=firstWorkMapper.selectByDynamic(firstName,status);
        logger.info(list.toString());
        return list;
    }




}
