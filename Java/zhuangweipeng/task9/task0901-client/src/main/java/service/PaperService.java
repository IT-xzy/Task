package service;


import pojo.PageBean;
import pojo.Paper;

import java.util.List;

public interface PaperService {
    boolean addPaper(Paper paper);

    //删除用户
    boolean deletePaperById(int paperId);

    boolean updatePaper(Paper paper);

    Paper queryById(int id);

    List<Paper> queryAllPaper();

    //List<Paper> queryAllPaper(int offset, int limit);
    int selectCount();

    //分页
    PageBean<Paper> findByPage(int currentPage);

    Paper getPaperById(String paperId);
}
