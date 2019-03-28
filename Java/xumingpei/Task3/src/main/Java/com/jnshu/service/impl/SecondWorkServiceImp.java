package com.jnshu.service.impl;

import com.jnshu.dao.SecondWorkMapper;
import com.jnshu.pojo.Reply;
import com.jnshu.pojo.SecondWork;
import com.jnshu.service.SecondWorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class SecondWorkServiceImp implements SecondWorkService {
    private static Logger logger = Logger.getLogger(SecondWorkServiceImp.class);

    @Autowired
    SecondWorkMapper secondWorkMapper;

    @Override
    public int deleteByPrimaryKey(Long secondId) {
        int ID = secondWorkMapper.deleteByPrimaryKey(secondId);
        logger.info("删除的id："+secondId);
        return ID;
    }

    @Override
    public int insert(SecondWork record) {
        int Record = secondWorkMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(SecondWork record) {
        int Recond = secondWorkMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public SecondWork selectByPrimaryKey(Long secondId) {
        SecondWork secondWork = secondWorkMapper.selectByPrimaryKey(secondId);
        logger.info("查询的ID"+secondId);
        return secondWork;
    }

    @Override
    public int updateByPrimaryKeySelective(SecondWork record) {
        int Recond = secondWorkMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(SecondWork record) {
        int Recond = secondWorkMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<SecondWork> selectByDynamic(String name, Integer status) {
        List<SecondWork> list=secondWorkMapper.selectByDynamic(name,status);
        logger.info(list.toString());
        return list;
    }

    @Override
    public List<SecondWork> selectFirstId(Long firstId) {
        List<SecondWork> list= secondWorkMapper.selectFirstId(firstId);
        logger.info(list.toString());
        return list;
    }
}
