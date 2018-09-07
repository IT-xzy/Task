package com.service;

import com.pojo.PageBean;
import com.pojo.Paper;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface PaperService {
    void addPaper(Paper paper) throws Exception;

    boolean deletePaperById(long id) throws Exception;

    boolean updatePaper(Paper paper) throws Exception;

    Paper queryById(int id) throws Exception;

    List<Paper> queryAllPaper() throws Exception;

    List<Paper> findPaperByName() throws Exception;

    int selectCount();

    //分页
    PageBean<Paper> findByPage(int currentPage);

    Paper getPaperById(String paperId);
}