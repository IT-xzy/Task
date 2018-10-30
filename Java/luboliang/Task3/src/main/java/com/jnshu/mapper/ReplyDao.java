package com.jnshu.mapper;

import com.jnshu.model.Reply;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ReplyDao {

    public long addReply(Reply reply);

    public boolean deleteReply(long id);

    public boolean updateReply(Reply reply);

    public Reply findByReply(long id);

    public List<Reply> findAllReply();
}
