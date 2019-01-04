package jnshu.service;

import jnshu.model.Author;
import jnshu.model.Visitor;

import java.util.List;

public interface GuestbookService {
//    Author的Dao层接口
    int deleteAuthorByPrimaryKey(Integer authorId);

    int insertAuthor(Author record);

    Author selectAuthorByPrimaryKey(Integer authorId);

    int updateAuthorByPrimaryKey(Author record);

//    visitor的Dao层接口
    int deleteVisitorByPrimaryKey(Integer visitorId);

    int insertVisitor(Visitor record);

    Visitor selectVisitorByPrimaryKey(Integer visitorId);

    int updateVisitorByPrimaryKey(Visitor record);

    //    查询对应作品的游客和作者的留言信息
    List selectGuestbook(int currentPage, int pageSize,int productionId);

}
