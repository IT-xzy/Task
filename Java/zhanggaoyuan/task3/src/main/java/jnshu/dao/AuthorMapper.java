package jnshu.dao;

import jnshu.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorMapper {
    int deleteByPrimaryKey(Integer authorId);

    int insert(Author record);

//    int insertSelective(Author record);

    Author selectByPrimaryKey(Integer authorId);

    int updateByPrimaryKeySelective(Author record);

//    int updateByPrimaryKey(Author record);
}