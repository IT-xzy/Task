package com.jnshu.service;

import com.jnshu.entity.Comment;
import com.jnshu.mapper.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;
    public List select(Comment comment){ return  commentDao.select(comment);}
    public Comment selectByPrimaryKey(long id){ return  commentDao.selectByPrimaryKey(id);}
    public int insertSelective(Comment comment){ return commentDao.insertSelective(comment); }
}
