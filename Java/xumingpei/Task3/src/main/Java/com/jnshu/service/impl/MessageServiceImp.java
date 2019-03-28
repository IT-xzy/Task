package com.jnshu.service.impl;

import com.jnshu.dao.MessageMapper;
import com.jnshu.pojo.FirstWork;
import com.jnshu.pojo.Message;
import com.jnshu.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class MessageServiceImp implements MessageService {
    private static Logger logger = Logger.getLogger(MessageServiceImp.class);

    @Autowired
    MessageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(Long msgId) {
        int ID = messageMapper.deleteByPrimaryKey(msgId);
        logger.info("删除的id："+msgId);
        return ID;
    }

    @Override
    public int insert(Message record) {
        int Record = messageMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(Message record) {
        int Recond = messageMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public Message selectByPrimaryKey(Long msgId) {
        Message message = messageMapper.selectByPrimaryKey(msgId);
        logger.info("查询的ID"+message);
        return message;
    }

    @Override
    public List<Message> selectworkId(Long workId, String status) {
        List<Message> list=messageMapper.selectworkId(workId,status);
        logger.info(list.toString());
        return list;
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        int Recond = messageMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        int Recond = messageMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<Message> selectByDynamic(String name, Integer status) {
        List<Message> list=messageMapper.selectByDynamic(name,status);
        logger.info(list.toString());
        return list;
    }
}
