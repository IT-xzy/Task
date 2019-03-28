package com.jnshu.service.impl;

import com.jnshu.dao.WorkMapper;
import com.jnshu.pojo.SecondWork;
import com.jnshu.pojo.Work;
import com.jnshu.service.WorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class WorkServiceImp implements WorkService {
    private static Logger logger = Logger.getLogger(WorkServiceImp.class);

    @Autowired
    WorkMapper workMapper;

    @Override
    public int deleteByPrimaryKey(Long workId) {
        int ID = workMapper.deleteByPrimaryKey(workId);
        logger.info("删除的id："+workId);
        return ID;
    }

    @Override
    public int insert(Work record) {
        int Record = workMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(Work record) {
        int Recond = workMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public Work selectByPrimaryKey(Long workId) {
        Work work = workMapper.selectByPrimaryKey(workId);
        logger.info("查询的ID"+work);
        return work;
    }

    @Override
    public int updateByPrimaryKeySelective(Work record) {
        int Recond = workMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(Work record) {
        int Recond = workMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<Work> selectByDynamic(String name, String introduction) {
        List<Work> list=workMapper.selectByDynamic(name,introduction);
        logger.info(list.toString());
        return list;
    }

    @Override
    public List<Work> selectsecondId(Long secondId) {
        List<Work> list= workMapper.selectsecondId(secondId);
        logger.info(list.toString());
        return list;
    }
}
