package jnshu.service.impl;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jnshu.dao.AuthorMapper;
import jnshu.dao.VisitorMapper;
import jnshu.model.Author;
import jnshu.model.Visitor;
import jnshu.service.GuestbookService;

import java.util.List;


@Service
public class GuestbookImpl implements GuestbookService{
    @Autowired
    AuthorMapper authorMapper;
    @Autowired
    VisitorMapper visitorMapper;

    @Override
    public int deleteAuthorByPrimaryKey(Integer authorId) {
        return authorMapper.deleteByPrimaryKey (authorId);
    }

    @Override
    public int insertAuthor(Author record) {
        return authorMapper.insert (record);
    }

    @Override
    public Author selectAuthorByPrimaryKey(Integer authorId) {
        return authorMapper.selectByPrimaryKey (authorId);
    }

    @Override
    public int updateAuthorByPrimaryKey(Author record) {
        return authorMapper.updateByPrimaryKeySelective (record);
    }


    @Override
    public int deleteVisitorByPrimaryKey(Integer visitorId) {
        return visitorMapper.deleteByPrimaryKey (visitorId);
    }

    @Override
    public int insertVisitor(Visitor record) {
        return visitorMapper.insert (record);
    }

    @Override
    public Visitor selectVisitorByPrimaryKey(Integer visitorId) {
        return visitorMapper.selectByPrimaryKey (visitorId);
    }

    @Override
    public int updateVisitorByPrimaryKey(Visitor record) {
        return visitorMapper.updateByPrimaryKeySelective (record);
    }

    //    查询对应作品的游客和作者的留言信息
    @Override
    public List selectGuestbook(int currentPage, int pageSize,int productionId) {
        PageHelper.offsetPage (currentPage-1, pageSize);
        return visitorMapper.selectGuestbook (productionId);
    }
}
