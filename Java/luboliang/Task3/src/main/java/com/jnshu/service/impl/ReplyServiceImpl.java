package com.jnshu.service.impl;

import com.jnshu.mapper.ReplyDao;
import com.jnshu.model.Reply;
import com.jnshu.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ReplyServiceImpl implements ReplyService {
    @Resource
    private ReplyDao replyDao;

    @Override
    public long addReply(Reply reply) {
        return replyDao.addReply(reply);
    }

    @Override
    public boolean deleteReply(long id) {
        return replyDao.deleteReply(id);
    }

    @Override
    public boolean updateReply(Reply reply) {
        return replyDao.updateReply(reply);
    }

    @Override
    public Reply findByReply(long id) {
        return replyDao.findByReply(id);
    }

    @Override
    public List<Reply> findAllReply() {
        return replyDao.findAllReply();
    }
}
