package com.art.service;

import com.art.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 留言管理
 * @author suger
 * @date 2018/11/4
 */
public interface CommentService {

    // 删除留言
    Boolean delete(Integer id);
    // 新增留言
    Boolean insert(Comment record);
    // 查看单个留言
    Comment getComment(Integer id);
    // 查看留言列表
    List<Comment> getComments(@Param("status") Boolean status, @Param("fromBy") String fromBy);
    // 更新留言
    Boolean update(Comment record);


}
