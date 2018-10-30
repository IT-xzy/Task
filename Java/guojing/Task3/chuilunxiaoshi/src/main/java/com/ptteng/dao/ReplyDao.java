package com.ptteng.dao;


import com.ptteng.entity.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyDao {

  long insertReply(Reply reply);

  Boolean deleteById(long id);

  Boolean updateReply(Reply reply);

  List<Reply> findReply(long bbsId);

}
