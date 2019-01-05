package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.CommentDao;
import com.xiaobo.demo.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Comment> getList(Comment comment, Map<String,Object> pageData){
        return commentDao.getList(comment,pageData);
    }
    @Override
    public Boolean add(Comment comment){
        return commentDao.add(comment);
    }
    @Override
    public Boolean update(Comment comment){
        return commentDao.update(comment);
    }
    @Override
    public Boolean delete(Comment comment){
        return commentDao.delete(comment);
    }
}
