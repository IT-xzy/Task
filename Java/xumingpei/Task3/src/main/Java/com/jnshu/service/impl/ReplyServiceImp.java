package com.jnshu.service.impl;

import com.jnshu.dao.ReplyMapper;
import com.jnshu.pojo.Reply;
import com.jnshu.service.ReplyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class ReplyServiceImp implements ReplyService {
    private static Logger logger = Logger.getLogger(ReplyServiceImp.class);

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int deleteByPrimaryKey(Long replyId) {
        int ID = replyMapper.deleteByPrimaryKey(replyId);
        logger.info("删除的id："+replyId);
        return ID;
    }

    @Override
    public int insert(Reply record) {
        int Record = replyMapper.insert(record);
        logger.info("插入的数据"+record);
        return Record;
    }

    @Override
    public int insertSelective(Reply record) {
        int Recond = replyMapper.insertSelective(record);
        logger.info("插入的数据"+record);
        return Recond;
    }

    @Override
    public Reply selectByPrimaryKey(Long replyId) {
        Reply reply = replyMapper.selectByPrimaryKey(replyId);
        logger.info("查询的ID"+reply);
        return reply;
    }

    @Override
    public int updateByPrimaryKeySelective(Reply record) {
        int Recond = replyMapper.updateByPrimaryKeySelective(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public int updateByPrimaryKey(Reply record) {
        int Recond = replyMapper.updateByPrimaryKey(record);
        logger.info("更新的数据："+record);
        return Recond;
    }

    @Override
    public List<Reply> selectByDynamic(Long replyId, String replyName) {
        List<Reply> list=replyMapper.selectByDynamic(replyId,replyName);
        logger.info(list.toString());
        return list;
    }

    @Override
    public Reply selectmsgId(Long msgId) {
        Reply reply = replyMapper.selectmsgId(msgId);
        logger.info("查询的ID"+msgId);
        return reply;
    }
}
