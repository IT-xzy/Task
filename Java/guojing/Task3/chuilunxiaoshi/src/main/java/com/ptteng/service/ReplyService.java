package com.ptteng.service;


import com.ptteng.dao.ReplyDao;
import com.ptteng.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyDao replyDao;

    public long insertReply(Reply reply){
        return replyDao.insertReply(reply);
    }

    public Boolean deleteById(long id){
        return replyDao.deleteById(id);
    }

    public Boolean updateReply(Reply reply){
        return replyDao.updateReply(reply);
    }

    public List<Reply> findReply(long bbsId){
        return replyDao.findReply(bbsId);
    }


}
