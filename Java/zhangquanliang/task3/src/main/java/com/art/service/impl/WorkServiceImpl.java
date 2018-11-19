package com.art.service.impl;

import com.art.mapper.WorkMapper;
import com.art.pojo.Work;
import com.art.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作品管理
 * @author suger
 * @date 2018/11/5 22:19
 */
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;
    private static final Logger logger = LoggerFactory.getLogger(WorkServiceImpl.class);

    @Override
    // 删除作品
    public Boolean delete(Integer id) {
        int result = workMapper.deleteByPrimaryKey(id);
        boolean tag = false;
        if(result==1){
            tag = true;
        }
        return tag;
    }

    @Override
    public Boolean insert(Work record) {
        int result = workMapper.insertSelective(record);
        boolean tag = false;
        if(result==1){
            tag = true;
        }
        return tag;
    }

    @Override
    public List<Work> getWork(Boolean status, String updateBy) {
        List<Work> list = workMapper.selectByCondition(status,updateBy);
        return list;
    }

    @Override
    public Work getWork(Integer id) {
        Work work = workMapper.selectByPrimaryKey(id);
        return work;
    }

    @Override
    public Boolean update(Work record) {
        int result = workMapper.updateByPrimaryKeySelective(record);
        boolean tag = false;
        if(result==1){
            tag = true;
        }
        return tag;
    }
}
