package com.art.service.impl;

import com.art.mapper.FirstMapper;
import com.art.pojo.First;
import com.art.service.FirstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/5 16:05
 */
@Service
public class FirstServiceImpl implements FirstService {
    @Autowired
    FirstMapper firstMapper;
    private static final Logger logger = LoggerFactory.getLogger(FirstServiceImpl.class);


    // CRUD 操作的标识符， 默认为false(失败）
    // ---目前会出现奇怪的错误，永远返回true
    // -----原因在于作用域---应该写到具体方法内
    // boolean tag = false;

    @Override
    // 新增作品集
    public Boolean insert(First record) {
        int result = firstMapper.insertSelective(record);
        logger.warn("新增：{}",result);
        boolean tag = false;
        // 新增成功，修改标识符
        if(result==1){
            tag = true;
        }
        return tag;
    }

    @Override
    // 删除作品集
    public Boolean delete(Integer id) {
        int result = firstMapper.deleteByPrimaryKey(id);
        logger.warn("删除：{}",result);
        boolean tag = false;
        if(result==1){
            // 删除成功
            tag = true;
        }
        return tag;
    }

    @Override
    // 获取单个作品集
    public First getFirst(Integer id) {
        if(id==null){
            logger.warn("输入ID不能为空");
        }
        logger.warn("查询作品集的ID：{}",id);
        return firstMapper.selectByPrimaryKey(id);
    }

    @Override
    // 根据 上架状态 与 最后编辑人 查询作品集
    public List<First> getFirst(Boolean status, String updateBy) {
        logger.info("查询条件,status:{},updateBy{}",status,updateBy);
        return firstMapper.selectByCondition(status,updateBy);
    }

    @Override
    // 更新 作品集,可以是条件更新
    public Boolean update(First record) {
        int result = firstMapper.updateByPrimaryKeySelective(record);
        logger.warn("更新：{}",result);
         // 更新 成功与否标志
        boolean tag = false;
        if(result==1){
            tag = true ;
        }
        return tag;
    }
}
