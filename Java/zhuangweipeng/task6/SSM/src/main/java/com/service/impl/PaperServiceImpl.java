package com.service.impl;

import com.dao.PaperDao;
import com.pojo.PageBean;
import com.pojo.Paper;
import com.service.PaperService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PaperServiceImpl.class);
    @Autowired
    private PaperDao paperDao;

    @Override
    public boolean addPaper(Paper paper) {
        return paperDao.addPaper(paper);
    }

    @Override
    public boolean deletePaperById(int id) {
        return paperDao.deletePaperById(id);
    }

    @Override
    public boolean updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    @Override
    public Paper queryById(int id) {
        logger.info("业务层取到的paperId=" + id);
        return paperDao.queryById(id);
    }

    @Override
    public List<Paper> queryAllPaper() {
        return paperDao.queryAllPaper();
    }

    @Override
    public Paper getPaperById(String paperId) {
        return paperDao.getPaperById(paperId);
    }

    @Override
    public int selectCount() {
        return paperDao.selectCount();
    }

    @Override
    public PageBean<Paper> findByPage(int currentPage) {
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Paper> pageBean = new PageBean<>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize = 8;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = paperDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整,除不尽的时候都向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start", (currentPage - 1) * pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Paper> lists = paperDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;

    }
}