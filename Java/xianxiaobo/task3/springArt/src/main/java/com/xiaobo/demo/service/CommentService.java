package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CommentService {
    public List<Comment> getList(Comment comment, Map<String,Object> pageData);
    public Boolean add(Comment comment);
    public Boolean update(Comment comment);
    public Boolean delete(Comment comment);
}
