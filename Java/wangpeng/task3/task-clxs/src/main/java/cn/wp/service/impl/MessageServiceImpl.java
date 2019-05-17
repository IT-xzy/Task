package cn.wp.service.impl;

import cn.wp.dao.MessageDao;
import cn.wp.model.Message;
import cn.wp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MessageServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:45
 * @Version: 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return messageDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Message record) {
        return messageDao.insert(record);
    }

    @Override
    public int insertSelective(Message record) {
        return messageDao.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Long id) {
        return messageDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return messageDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return messageDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Message> selectAll() {
        return messageDao.selectAll();
    }

    @Override
    public List<Message> selectByDynamicCondition(String username, Long state) {
        return messageDao.selectByDynamicCondition(username, state);
    }
}
