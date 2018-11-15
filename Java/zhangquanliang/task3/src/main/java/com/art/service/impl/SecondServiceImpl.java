package com.art.service.impl;

import com.art.mapper.SecondMapper;
import com.art.pojo.Second;
import com.art.service.SecondService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作品分类service
 * @author suger
 * @date 2018/11/5 17:47
 */

@Service
public class SecondServiceImpl implements SecondService {

    @Autowired
    SecondMapper secondMapper;

    private static final Logger logger = LoggerFactory.getLogger(SecondServiceImpl.class);

    // 新增、更新、删除操作的标识符， 默认操作失败
    // boolean tag = false;

    // 新增作品分类
    @Override
    public Boolean insert(Second record) {
        int result = secondMapper.insertSelective(record);
        logger.warn("新增作品集：{}",result);

        boolean tag = false;

        if(result==1){
            tag = true;
        }
        return tag;
    }
    // 删除作品集
    @Override
    public Boolean delete(Integer id) {

        int result = secondMapper.deleteByPrimaryKey(id);
        logger.warn("删除作品集：{}",result);
        boolean tag = false;
        if(result==1){
            tag = true;
        }
        return tag;
    }
   // 查询单个作品集
    @Override
    public Second getSecond(Integer id) {
        logger.info("查询作品集ID:{}",id);
        Second second = secondMapper.selectByPrimaryKey(id);
        return second;
    }
    // 查询 作品集列表
    @Override
    public List<Second> getSecond(Boolean status, String updateBy){

        List<Second> secondList = secondMapper.selectByCondition(status,updateBy);
        return secondList;
    }

     // 更新作品分类
    @Override
    public Boolean update(Second record) {
        int result = secondMapper.updateByPrimaryKeySelective(record);
        logger.warn("更新作品分类：{}",result);
        boolean tag = false;

        if(result==1){
            tag = true ;
        }
        return tag;
    }
}
