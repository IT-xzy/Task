package com.service;

import com.pojo.PageBean;
import com.pojo.Paper;

import java.util.List;

public interface PaperService {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);
    List<Paper> queryAllPaper();
    int selectCount();
    //分页
    PageBean<Paper> findByPage(int currentPage);

    Paper getPaperById(String paperId);
}