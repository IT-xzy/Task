package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    public List<Comment> getList(@Param("comment")Comment comment, @Param("pageData") Map<String,Object> pageData);
    public Boolean add(Comment comment);
    public Boolean delete(Comment comment);
    public Boolean update(Comment comment);
}
