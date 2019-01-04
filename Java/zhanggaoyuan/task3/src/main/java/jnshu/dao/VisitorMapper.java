package jnshu.dao;

import org.springframework.stereotype.Repository;
import jnshu.model.Visitor;

import java.util.List;

@Repository
public interface VisitorMapper {
    int deleteByPrimaryKey(Integer visitorId);

    int insert(Visitor record);

//    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer visitorId);

    int updateByPrimaryKeySelective(Visitor record);

//    查询对应作品的游客和作者的留言信息
    List selectGuestbook(int productionId);
//    int updateByPrimaryKey(Visitor record);
}