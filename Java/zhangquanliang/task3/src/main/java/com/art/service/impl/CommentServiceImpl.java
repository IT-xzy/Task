package com.art.service.impl;

import com.art.mapper.CommentMapper;
import com.art.pojo.Comment;
import com.art.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言管理
 * @author suger
 * @date 2018/11/5 09:33
 */
@Service

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    private static final Logger logger = LoggerFactory.getLogger(CommentMapper.class);

    // 删除留言
    @Override
    public Boolean delete(Integer id) {

        int result = commentMapper.deleteByPrimaryKey(id);
        if(result==1){
            return true;
        }
        return false;
    }

    // 新增留言
    @Override
    public Boolean insert(Comment record) {
        int result = commentMapper.insertSelective(record);
        if(result==1){
            return true;
        }
        return false;
    }

    // 查看单个留言
    @Override
    public Comment getComment(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> getComments(Boolean status, String fromBy) {
        return commentMapper.selectByCondition(status,fromBy);
    }

    // 更新留言
    @Override
    public Boolean update(Comment record) {
        int result = commentMapper.updateByPrimaryKeySelective(record);
        if(result==1){
            return true;
        }
        return false;
    }
}
