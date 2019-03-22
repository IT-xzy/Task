package com.jnshu.service.impl;

import com.jnshu.dao.ReplyMapper;
import com.jnshu.pojo.Reply;
import com.jnshu.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class ReplyServiceImp implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return replyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Reply record) {
        return replyMapper.insert(record);
    }

    @Override
    public int insertSelective(Reply record) {
        return replyMapper.insertSelective(record);
    }

    @Override
    public Reply selectByPrimaryKey(Long id) {
        return replyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Reply record) {
        return replyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Reply record) {
        return replyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Reply> selectByDynamic(Long id, String replyName) {
        return replyMapper.selectByDynamic(id,replyName);
    }
}
