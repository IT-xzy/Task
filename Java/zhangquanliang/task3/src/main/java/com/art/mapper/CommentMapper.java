package com.art.mapper;

import com.art.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectByCondition(@Param("status") Boolean status, @Param("fromBy") String fromBy);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}